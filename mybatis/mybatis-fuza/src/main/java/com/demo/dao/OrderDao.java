package com.demo.dao;

import com.demo.pojo.Order;

/**
 * @author why
 * @date 2021/10/20 14:34
 * @PackageName com.demo.dao
 * @description 一对一或者多对一
 */
public interface OrderDao {
    //根据订单id查询订单，要求把下单用户的信息也查询出来
    //一对一或者多对一
    Order findById(Integer id);
}
