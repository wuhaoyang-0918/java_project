package com.why.test;

import com.demo.dao.OrderDao;
import com.demo.dao.UserDao;
import com.demo.pojo.Order;
import com.demo.pojo.User;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author why
 * @date 2021/10/20 14:48
 * @PackageName com.why.test
 * @description
 */
public class DemoTest {
    private InputStream input;
    private SqlSession session;

    @Before
    public void BeforeTe() throws IOException {
        // 1.读取配置文件
        input = Resources.getResourceAsStream("mybatis.xml");
        // 2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        // 3.获取SqlSession 对象
        session = factory.openSession();//参数为true表示自动提交 就不用commit  默认是需要手工提交事务的false

    }
    @After
    public void AfterTe() throws IOException {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        //释放流
        input.close();
    }

    /**
     * 一对一或者多对一
     */
    @Test
    public void  getUserList(){
        // 4.获取dao接口的代理对象(实现类对象)
         OrderDao  orderDao = session.getMapper(OrderDao.class);
         Order byId = orderDao.findById(2);
         System.out.println(byId);
    }
    /**
     * 一对多
     */
    @Test
    public void  getUserList1(){
         UserDao userDao=session.getMapper(UserDao.class);
         User byId = userDao.findById(2);
         System.out.println(byId);
    }
    /**
     * 分步查询一对多
     */
    @Test
    public void  getUserList2(){
        UserDao userDao=session.getMapper(UserDao.class);
        User byId = userDao.findByUsername("pdd");
        System.out.println(byId);
    }
    /**
     * 分步查询解决一对多的分页问题
     */
    @Test
    public void  getUserList3(){
        UserDao userDao=session.getMapper(UserDao.class);
        PageHelper.startPage(1,1);
         List<User> all = userDao.findAll();
         all.forEach(System.out::println);

    }
}
