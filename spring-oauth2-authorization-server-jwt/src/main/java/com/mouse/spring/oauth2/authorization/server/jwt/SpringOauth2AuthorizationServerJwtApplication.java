package com.mouse.spring.oauth2.authorization.server.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOauth2AuthorizationServerJwtApplication {

    /**
     * http://localhost:8080/oauth/authorize?client_id=app-jwt&response_type=code&redirect_uri=http://baidu.com
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2AuthorizationServerJwtApplication.class, args);
    }

}
