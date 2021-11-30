package com.example.controller;

import com.example.Exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/9/30 21:34
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class TestController {

    @RequestMapping("testMyException")
    public String stringtestException() throws Exception{
        throw new MyException("i am a myException");
    }
    @RequestMapping("myException")
    public String myException() throws Exception{
        throw new MyException(400L,"自定义异常");
    }

}
