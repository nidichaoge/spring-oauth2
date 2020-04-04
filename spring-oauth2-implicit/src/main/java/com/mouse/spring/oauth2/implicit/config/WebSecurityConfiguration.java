package com.mouse.spring.oauth2.implicit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-24
 * @description
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/oauth/**","/login/**", "/logout").permitAll()
//                .anyRequest().authenticated()
//        .and()
//        .formLogin().loginPage("/login");
//        http
//                .requestMatchers().antMatchers("/oauth/**","/login/**")
////                .requestMatchers().antMatchers("/oauth/**","/login/**","/logout/**")
//                .and()
//                .authorizeRequests()
////                .antMatchers("/oauth/**").authenticated()
//                .and()
//                .formLogin().permitAll(); //新增login form支持用户登录及授权
        http.authorizeRequests().antMatchers("/oauth/**","/login/**")
                .authenticated()
                .and()
                .formLogin().permitAll();

    }
}
