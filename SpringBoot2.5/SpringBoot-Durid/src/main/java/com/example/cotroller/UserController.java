package com.example.cotroller;



import com.example.mapper1.UserDao;
import com.example.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/user")
    public List<User> sho(){
        return userDao.findAll();

    }


}
