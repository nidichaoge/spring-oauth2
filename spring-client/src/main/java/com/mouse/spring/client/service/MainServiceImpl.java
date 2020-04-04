package com.mouse.spring.client.service;

import com.mouse.spring.client.dal.dao.UserRepository;
import com.mouse.spring.client.dal.dataobject.UserDO;
import com.mouse.spring.client.entity.OAuth2Token;
import com.mouse.spring.client.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
@Service
public class MainServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainServiceImpl.class);

    @Resource
    private UserRepository userRepository;
    @Resource
    private TokenServiceImpl tokenService;

    public String oauth() {
        //可以通过SecurityContextHolder拿到用户信息
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //重定向到授权界面 用户授权 回调绑定用户信息
        String authorizationUrl = tokenService.generateAuthorizationUrl(userInfo.getUsername());
        return authorizationUrl;
    }

    public Boolean bind(String code, String state) {
        UserDO byUsername = userRepository.findByUsername(state);
        if (StringUtils.isEmpty(byUsername.getAccessToken())) {
            OAuth2Token token = tokenService.getToken(code);
            LOGGER.info("{}.", token);
            byUsername.setAccessToken(token.getAccessToken());
            byUsername.setRefreshToken(token.getRefreshToken());
            long expireIn = Long.parseLong(token.getExpiresIn());
            LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(expireIn);
            byUsername.setAccessTokenValidity(localDateTime);
            userRepository.save(byUsername);
        }
        return Boolean.TRUE;
    }
}
