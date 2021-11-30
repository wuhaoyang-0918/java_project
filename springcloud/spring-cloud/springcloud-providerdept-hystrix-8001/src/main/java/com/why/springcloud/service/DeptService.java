package com.why.springcloud.service;

import com.why.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-11 14:53
 * @description: DeptService
 * @version: 1.0
 */
public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
