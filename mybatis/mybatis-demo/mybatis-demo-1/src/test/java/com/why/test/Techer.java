package com.why.test;

import com.why.mapper.StudentMapper;
import com.why.mapper.TeacherMapper;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 昊洋
 * @date:2021-08-06 16:50
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Techer {
    @Test
    public void  getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher(1));
    }
}
