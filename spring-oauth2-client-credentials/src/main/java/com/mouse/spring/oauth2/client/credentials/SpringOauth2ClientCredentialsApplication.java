package com.mouse.spring.oauth2.client.credentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOauth2ClientCredentialsApplication {

    /**
     * 客户端模式
     * 使用如下命令获取access_token
     * curl app:112233@localhost:8080/oauth/token -dgrant_type=client_credentials -dscope=read
     * 注意事项
     * 无
     * <p>
     * 浏览器中访问 http://app:112233@localhost:8080/oauth/token
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2ClientCredentialsApplication.class, args);
    }

}
