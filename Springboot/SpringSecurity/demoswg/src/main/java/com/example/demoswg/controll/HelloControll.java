package com.example.demoswg.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 昊洋
 * @date:2020-07-20 9:06
 * @description: HelloControll
 * @version: 1.0
 */
@RestController
public class HelloControll {
    @RequestMapping("/hello")
    public String sho(){
        return "sessucc";
    }
}
