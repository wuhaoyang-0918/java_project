package com.example.mapper;

import com.example.pojo.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * The interface System user dao.
 *
 * @author why
 * @date 2021 /10/22 22:42
 * @PackageName com.example.dao
 * @description
 */
@Mapper
public interface SystemUserDao {

    /**
     * Login system user.
     *
     * @param user the user
     * @return the system user
     */
    public SystemUser login(SystemUser user);
}
