package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/9/29 12:38
 * @PackageName com.example.controller
 * @description
 */
@RestController
@Slf4j
public class Demo {
    @RequestMapping("/getName")
    public String getName(String name, int age) {

        log.info("name:{},age:{}",name,age);
        log.warn("name:{},age:{}",name,age);
        try {

        } catch (Exception e) {
            log.error("{-----程序发生错误-----}");
            e.printStackTrace();
        }
        return "name";
    }

}
