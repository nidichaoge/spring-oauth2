package com.mouse.spring.oauth2.resource.owner.credentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOauth2ResourceOwnerCredentialsApplication {

    /**
     * 密码模式
     * 使用如下命令获取access_token
     * curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=password&username=mouse&password=123456&scope=read' "http://app:112233@localhost:8080/oauth/token"
     *
     * 注意事项
     * 必须注入 AuthenticationManager 和 UserDetailsService
     * <p>
     * 如何在浏览器中访问? http://localhost:8080/oauth/token?username=mouse&password=123456&grant_type=password&client_id=app&client_secret=112233
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2ResourceOwnerCredentialsApplication.class, args);
    }

}
