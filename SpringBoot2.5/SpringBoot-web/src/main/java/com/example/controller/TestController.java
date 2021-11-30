package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/10/22 13:12
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
