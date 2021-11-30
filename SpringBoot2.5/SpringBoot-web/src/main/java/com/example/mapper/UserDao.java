package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * The interface User dao.
 *
 * @author why
 * @date 2021 /10/22 13:26
 * @PackageName com.example.dao
 * @description
 */
@Mapper
public interface UserDao {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

    /**
     * Insert user.
     *
     * @param user the user
     */
    void insertUser(User user);
}
