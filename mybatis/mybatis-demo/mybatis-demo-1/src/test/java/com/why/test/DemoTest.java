package com.why.test;

import com.why.mapper.FindUserDao;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 昊洋
 * @date:2021-08-06 21:40
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class DemoTest {
    private InputStream input;
    private SqlSession session;
    private FindUserDao mapper;
    @Before
    public void BeforeTe() throws IOException {
        // 1.读取配置文件
        input = Resources.getResourceAsStream("mybatis.xml");
        // 2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        // 3.获取SqlSession 对象
        session = factory.openSession();//参数为true表示自动提交 就不用commit  默认是需要手工提交事务的false
        // 4.获取dao接口的代理对象(实现类对象)
        mapper = session.getMapper(FindUserDao.class);
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
    @Test
    public void  getUserList(){
        System.out.println(mapper.getUserList());
    }
}
