package com.demo.service.impl;

import com.demo.dao.AccoutDao;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author why
 * @date 2021/10/19 13:33
 * @PackageName com.demo.service.impl
 * @description
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccoutDao accoutDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transfer(Integer outId, Integer inId, Double money) {
        //增加
        accoutDao.updateMoney(inId,money);
        //减少
        accoutDao.updateMoney(outId,-money);
    }

    @Override
    @Transactional(readOnly = true)
    public void log() {
        System.out.println("打印日志");
        int i = 1/0;
    }
}
