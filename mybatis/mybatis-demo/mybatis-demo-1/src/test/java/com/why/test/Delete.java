package com.why.test;

import com.why.mapper.DeleteUserDao;
import com.why.mapper.UpdateUserDao;
import com.why.pojo.User;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author 昊洋
 * @date:2021-08-05 22:11
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Delete {
    static Logger logger = Logger.getLogger(Delete.class);

    @Test
    public void delUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeleteUserDao mapper = sqlSession.getMapper(DeleteUserDao.class);
        System.out.println(mapper.delUserById(6));
        sqlSession.commit();
    }
    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
    }
}
