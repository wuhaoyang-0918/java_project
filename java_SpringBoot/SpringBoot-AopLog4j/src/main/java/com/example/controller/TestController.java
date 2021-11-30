package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/9/29 21:45
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class TestController {

    @RequestMapping("/getName")
    public String getName(String name, int age) {
        int i =10/0;
        return "name";
    }
}
