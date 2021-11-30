package com.example.controller;

import com.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/10/21 19:20
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class HelloController {
    @Autowired
    private Student student;
    @RequestMapping("/hello")
    public Student hello() {
        return student;
    }


}
