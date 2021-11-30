package com.example.mapper1;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author why
 * @date 2021/10/22 13:26
 * @PackageName com.example.dao
 * @description
 */
@Mapper
public interface UserDao {
    List<User> findAll();
}
