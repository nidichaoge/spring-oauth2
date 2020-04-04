package com.mouse.spring.oauth2.resource.server.controller;

import com.mouse.spring.oauth2.resource.server.response.UserInfo;
import com.mouse.spring.oauth2.resource.server.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-24
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    public UserInfo getUserInfo(@RequestParam String userId) {
        UserInfo userInfo = userService.getUserInfo(userId);
        return userInfo;
    }

}
