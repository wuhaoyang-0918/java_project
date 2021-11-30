package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.User;
import com.example.redistest.RedisTemplateUtils;
import com.example.redistest.RedisUserTemplateUtils;
import com.example.redistest.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author why
 * @date 2021/10/28 10:49
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class Usercotroller {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    RedisTemplateUtils redisTemplateUtils;
    @Autowired
    RedisUserTemplateUtils redisUserTemplateUtils;
    /**
     * StringRedisTemplate或者RedisTemplate<String,String>不需要配置
     */
   /* @RequestMapping("/add")
    public String addUser(){

         String zs = JSONObject.toJSONString(new User(1L, "zs"));
        redisUtils.setString("use_string",zs,10L);
        return "success";
    }
    @RequestMapping("/get")
    public User getUser(){
        return JSONObject.parseObject(redisUtils.getString("use_string"), User.class);
    }*/

    /**
     * RedisTemplate<String,User>需要配置
     */
    /* @RequestMapping("/add")
    public String addUser(){
         userTemplateUtils.setObject("use_string",new User(1L, "zs"),100L);
        return "success";
    }
    @RequestMapping("/get")
    public User getUser(){
        return userTemplateUtils.getObject("use_string");
     }*/
    @RequestMapping("/add")
    public String addUser(){
        redisTemplateUtils.setObject("use_string",new User(1L, "zs"),100L);
        return "success";
    }
    @RequestMapping("/get")
    public User getUser(){
        return (User) redisTemplateUtils.getObject("use_string");
    }
}
