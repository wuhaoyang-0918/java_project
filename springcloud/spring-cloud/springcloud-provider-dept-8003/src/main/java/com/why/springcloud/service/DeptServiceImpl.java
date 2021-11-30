package com.why.springcloud.service;

import com.why.springcloud.dao.DeptDao;
import com.why.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-11 14:53
 * @description: DeptService
 * @version: 1.0
 */
@Service
public class DeptServiceImpl implements  DeptService{
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
