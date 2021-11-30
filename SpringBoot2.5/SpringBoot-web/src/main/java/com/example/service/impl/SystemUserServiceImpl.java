package com.example.service.impl;

import com.example.mapper.SystemUserDao;
import com.example.pojo.SystemUser;
import com.example.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author why
 * @date 2021/10/22 22:48
 * @PackageName com.example.service.impl
 * @description
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    @Override
    public SystemUser login(SystemUser user) {

        return systemUserDao.login(user);
    }
}
