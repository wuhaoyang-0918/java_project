package com.example.demo1.service;

import com.example.demo1.mapper.UserMapper;
import com.example.demo1.pojo.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 昊洋
 * @date:2020-07-19 15:57
 * @description: UseService
 * @version: 1.0
 */
@Service
public class UseServiceImpl implements UseService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     */
    @Override
    public Use queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }


}
