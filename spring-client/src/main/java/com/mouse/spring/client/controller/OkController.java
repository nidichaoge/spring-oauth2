package com.mouse.spring.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
@RestController
public class OkController {

    private static final String OK = "ok";

    @GetMapping("/ok")
    public String ok() {
        return OK;
    }

}
