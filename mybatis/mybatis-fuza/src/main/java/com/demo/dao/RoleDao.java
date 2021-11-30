package com.demo.dao;

import javax.management.relation.Role;
import java.util.List;

/**
 * @author why
 * @date 2021/10/20 15:23
 * @PackageName com.demo.dao
 * @description
 */
public interface RoleDao {
    //分步查询
    //根据userId查询所具有的角色
    List<Role> findRoleByUserId(Integer userId);
}
