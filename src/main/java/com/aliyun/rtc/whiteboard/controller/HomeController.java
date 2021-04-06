package com.aliyun.rtc.whiteboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 根 Controller
 */
@RestController
public class HomeController {

    /**
     * 健康检查
     */
    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public String healthCheck() {
        return "Success";
    }
}
