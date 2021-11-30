package com.demo.dao;

import com.demo.pojo.User;

import java.util.List;

/**
 * @author why
 * @date 2021/10/20 14:58
 * @PackageName com.demo.dao
 * @description  // 一对多
 */
public interface UserDao {

    //一对多引发分页问题(解决方案)
    //查询所有用户，并且要求把用户所具有的角色信息也查询出来
    List<User> findAll();

    //根据id查询用户，并且要求把该用户所具有的角色信息也查询出来
    // 一对多
    User findById(Integer id);


    //因为我们要分两步查询: 1.查询User 2.根据用户的id查询Role
    //根据用户名查询用户，并且要求把该用户所具有的角色信息也查询出来
    User findByUsername(String username);

}
