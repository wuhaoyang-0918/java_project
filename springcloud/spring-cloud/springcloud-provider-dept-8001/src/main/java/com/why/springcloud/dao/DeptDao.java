package com.why.springcloud.dao;

import com.why.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-11 14:28
 * @description: DeptDao
 * @version: 1.0
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();

}
