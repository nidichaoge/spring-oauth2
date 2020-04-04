package com.mouse.spring.client.controller;

import com.mouse.spring.client.service.MainServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Resource
    private MainServiceImpl mainService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main")
    public ModelAndView main() {
        String oauth = mainService.oauth();
        return new ModelAndView("redirect:" + oauth);
    }

    @GetMapping("/callback")
    @ResponseBody
    public String callback(@RequestParam String code, @RequestParam String state) {
        LOGGER.info("code:{}, state:{}.", code, state);
        mainService.bind(code,state);
        return "ok";
    }
}
