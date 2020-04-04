package com.mouse.spring.client.service;

import com.mouse.spring.client.entity.OAuth2Token;
import com.mouse.spring.client.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.*;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
@Service
public class TokenServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImpl.class);

    private static final String ENDPOINT = "http://localhost:8080/oauth/authorize";
    private static final String CLIENT_ID = "client";
    private static final String CLIENT_SECRET = "secret";
    private static final String REDIRECT_URL = "http://localhost/callback";

    public String generateAuthorizationUrl(String state) {

        Map<String, String> authParameters = new HashMap<>();
        authParameters.put("client_id", CLIENT_ID);
        authParameters.put("response_type", "code");
        authParameters.put("redirect_uri", REDIRECT_URL);
        authParameters.put("scope", "read");
        authParameters.put("state", state);
        String url = buildUrl(ENDPOINT, authParameters);
        LOGGER.info("url:{}.", url);
        return url;
    }

    public OAuth2Token getToken(String authorizationCode) {
        RestTemplate rest = new RestTemplate();
        String authBase64 = encodeCredentials("client",
                "secret");

        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(
                getBody(authorizationCode),
                getHeader(authBase64), HttpMethod.POST,
                URI.create("http://localhost:8080/oauth/token"));

        ResponseEntity<OAuth2Token> responseEntity = rest.exchange(
                requestEntity, OAuth2Token.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }

        throw new RuntimeException("error trying to retrieve access token");
    }

    public String encodeCredentials(String username, String password) {
        String credentials = username + ":" + password;
        String encoded = new String(Base64.getEncoder().encode(
                credentials.getBytes()));

        return encoded;
    }

    public MultiValueMap<String, String> getBody(String authorizationCode) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("scope", "read");
        formData.add("code", authorizationCode);
        formData.add("redirect_uri", "http://localhost/callback");
        return formData;
    }

    public HttpHeaders getHeader(String clientAuthentication) {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Basic " + clientAuthentication);

        return httpHeaders;
    }

    private String buildUrl(String endpoint, Map<String, String> parameters) {
        List<String> paramList = new ArrayList<>(parameters.size());

        parameters.forEach((name, value) -> paramList.add(name + "=" + value));

        return endpoint + "?" + paramList.stream().reduce((a, b) -> a + "&" + b).get();
    }
}
