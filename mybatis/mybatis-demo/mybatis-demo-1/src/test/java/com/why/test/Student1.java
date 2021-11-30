package com.why.test;

import com.why.mapper.InsertUserDao;
import com.why.mapper.StudentMapper;
import com.why.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 昊洋
 * @date:2021-08-06 15:45
 * @PackageName: com.why.test
 * @description:
 * @Version 1.0
 */
public class Student1 {
    /**
     * 查询所有的学生信息以及对应的老师信息(一对一或者多对一)
     */
    @Test
    public void getStudentTeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.getStudentTeach().forEach(System.out::println);
    }
    /**
     * 查询所有的学生信息以及对应的老师信息(一对一或者多对一)
     */
    @Test
    public void getStudentTeach1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.getStudentTeach1().forEach(System.out::println);
    }
}
