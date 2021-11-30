package com.example.service.impl;

import com.example.mapper.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author why
 * @date 2021/10/22 13:31
 * @PackageName com.example.service.impl
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void insertUser() {
        userDao.insertUser(new User(null,"ss66",11,"上海"));
        int i=1/0;
        userDao.insertUser(new User(null,"ss67",12,"花坛"));
    }
}
