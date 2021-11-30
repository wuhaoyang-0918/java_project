package com.why.test;

import com.why.mapper.FindUserDao;
import com.why.mapper.InsertUserDao;
import com.why.pojo.User;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-05 17:39
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Insert {
    /**
     * 注意：增删改需要提交事务
     */
    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        InsertUserDao mapper = sqlSession.getMapper(InsertUserDao.class);
        User user=new User();
        user.setId(15);
        user.setName("15");
        user.setPwd("15");
        System.out.println(mapper.addUser(user));
        sqlSession.commit();
        sqlSession.close();
        ;
    }

    /**
     * set插入获取插入主键值
     */
    @Test
    public void insertUserFindId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        InsertUserDao mapper = sqlSession.getMapper(InsertUserDao.class);
        User user=new User();
        user.setName("李四");
        user.setPwd("li");
        mapper.addUserFindId(user);
        System.out.println(user.getId());
        sqlSession.commit();

    }

    /**
     * Trim非空字段进行插入
     */
    @Test
    public void insertSelective(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        InsertUserDao mapper = sqlSession.getMapper(InsertUserDao.class);
        User user=new User();
        user.setId(-1);
        user.setName("李四2");
        user.setPwd("lisi2");
        mapper.insertSelective(user);
        sqlSession.commit();
    }

    /**
     * 批量插入
     */
    @Test
    public void batchInsertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        InsertUserDao mapper = sqlSession.getMapper(InsertUserDao.class);
        User user=new User();
        user.setId(13);
        user.setName("13");
        user.setPwd("13");
        User user1=new User();
        user1.setId(14);
        user1.setName("14");
        user1.setPwd("14");
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(user1);
        mapper.batchInsertUser(list);
        sqlSession.commit();
    }

}
