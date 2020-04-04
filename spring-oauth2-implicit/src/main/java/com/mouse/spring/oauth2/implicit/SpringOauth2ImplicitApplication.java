package com.mouse.spring.oauth2.implicit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOauth2ImplicitApplication {

    /**
     * 简化模式
     * 使用如下地址在浏览器中获取access_token
     * http://localhost:8080/oauth/authorize?response_type=token&client_id=app&redirect_uri=http://baidu.com
     * 需要输入用户名和密码确认授权后直接返回access_token
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2ImplicitApplication.class, args);
    }

}
