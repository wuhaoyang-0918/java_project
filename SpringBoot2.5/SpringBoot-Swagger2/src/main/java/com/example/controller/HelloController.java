package com.example.controller;

import com.example.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/10/25 16:15
 * @PackageName com.example.controller
 * @description
 */
@Api(tags = "用户控制类")
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("查询用户名")
    @PostMapping("/username")
    public String getUserName(@ApiParam("用户名") String username) {
        return username;
    }
    @GetMapping("/addUser")
    public User getUser(User user) {
        return new User();
    }
}
