package com.demo.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author why
 * @date 2021/10/19 13:31
 * @PackageName com.demo.dao
 * @description
 */
public interface AccoutDao {

    void updateMoney(@Param("id") Integer id, @Param("updateMoney") Double updateMoney);
}