package com.example.demo1.mapper;

import com.example.demo1.pojo.Use;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @author 昊洋
 * @date:2020-07-19 15:32
 * @description: UserMapper
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 登录
     */
    public Use queryUserByName(String name);
}
