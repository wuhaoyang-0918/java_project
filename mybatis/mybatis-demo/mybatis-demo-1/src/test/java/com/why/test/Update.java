package com.why.test;

import com.why.mapper.FindUserDao;
import com.why.mapper.UpdateUserDao;
import com.why.pojo.User;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 昊洋
 * @date:2021-08-05 15:49
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Update {
    /**
     * set更新
     */
    @Test
    public void  UpdateSet(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UpdateUserDao mapper = sqlSession.getMapper(UpdateUserDao.class);
        User user=new User();
        user.setName("");
        user.setPwd("1999");
        System.out.println(mapper.updateUser(user));
        sqlSession.commit();
    }
    @Test
    public void  UpdateTrim(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UpdateUserDao mapper = sqlSession.getMapper(UpdateUserDao.class);
        User user=new User();
        user.setId(5);
        user.setName("lisi");
        user.setPwd("1998");
        System.out.println(mapper.trimUpdateUser(user));
        sqlSession.commit();
    }
}
