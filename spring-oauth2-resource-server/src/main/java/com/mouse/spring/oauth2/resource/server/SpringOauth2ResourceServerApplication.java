package com.mouse.spring.oauth2.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class SpringOauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2ResourceServerApplication.class, args);
	}

}
