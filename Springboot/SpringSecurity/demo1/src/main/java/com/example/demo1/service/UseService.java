package com.example.demo1.service;

import com.example.demo1.pojo.Use;

/**
 * @author 昊洋
 * @date:2020-07-19 15:57
 * @description: UseService
 * @version: 1.0
 */
public interface UseService {
    /**
     * 登录
     */
    public Use queryUserByName(String name);
}
