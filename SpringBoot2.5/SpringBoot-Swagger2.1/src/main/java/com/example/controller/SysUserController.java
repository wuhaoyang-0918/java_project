package com.example.controller;

import com.example.User.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/10/25 16:47
 * @PackageName com.example.controller
 * @description
 */
@Api(tags = "用户操作模块API")//作用在模块API类上，对API模块进行说明
@RestController(value = "/sys/user/")
public class SysUserController {
    @ApiOperation("添加用户接口")//作用在API方法上，对操作进行说明
    @PostMapping(value = "/add")
    public String add(User user) {
        return "success";
    }

    @ApiOperation("根据ID查询用户")
    @GetMapping(value = "/user")
    //作用在参数上，对参数进行说明
    public User find(
            @ApiParam(name = "用户ID", required = true) Integer id) {
        return new User();
    }

    @ApiOperation("更新用户")
    @PostMapping(value = "/update")
    public String update(
            @ApiParam("用户对象") User user) {
        return "success";
    }

    @ApiOperation("删除用户")
    @GetMapping(value = "/delete")
    public Integer delete(@ApiParam("用户ID") Integer id) {
        return 1;
    }
}
