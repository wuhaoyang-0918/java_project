package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @author why
 * @date 2021/10/22 13:30
 * @PackageName com.example.service
 * @description
 */
public interface UserService {
    List<User> findAll();

    void insertUser();
}
