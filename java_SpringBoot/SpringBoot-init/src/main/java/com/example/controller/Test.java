package com.example.controller;

import com.example.pojo.Dog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/10/21 11:23
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class Test {
    @RequestMapping("/dog")
    public Dog show(Dog dog){
        return dog;
    }
}
