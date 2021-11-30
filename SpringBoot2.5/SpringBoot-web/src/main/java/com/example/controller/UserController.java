package com.example.controller;
import java.util.ArrayList;

import com.example.Result.ResponseResult;
import com.example.interface1.CurrentUserId;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author why
 * @date 2021/10/22 13:32
 * @PackageName com.example.controller
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/insertUser")
    public ResponseResult insertUser(){
        userService.insertUser();
        return new ResponseResult(200,"添加成功!");
    }


    @RequestMapping("/findAll")
    public ResponseResult findAll(@CurrentUserId String userId){
        System.out.println(userId);
        return new ResponseResult(200,userService.findAll());
        //return new ResponseResult(201,"异常");


    }

}
