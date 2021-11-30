package com.example.controller;

import com.example.Result.ResponseResult;
import com.example.pojo.SystemUser;
import com.example.service.SystemUserService;
import com.example.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The type System user controller.
 *
 * @author why
 * @date 2021 /10/22 22:41
 * @PackageName com.example.controller
 * @description
 */
@RestController
@RequestMapping("/sys_user")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUser;


    /**
     * Login response result.
     *
     * @param user the user
     * @return the response result
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser user) {
        SystemUser login = systemUser.login(user);
        Map<String, String> map;
        if (login != null) {
             //如果正确 生成token返回给前端
             map=new HashMap<>();
             String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(login.getId()), null);
             map.put("token",token);
        }else {
            return new ResponseResult(300, "用户名或密码错误,请重新登录");
        }
        return new ResponseResult(200, "登录成功",map);
    }
}
