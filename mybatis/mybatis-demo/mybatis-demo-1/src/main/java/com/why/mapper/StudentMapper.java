package com.why.mapper;

import com.why.pojo.Student;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-06 15:30
 * @PackageName: com.why.mapper
 * @description:
 * @Version 1.0
 */
public interface StudentMapper {
    /***查询嵌套
     * Desc:查询所有的学生信息以及对应的老师信息(一对一或者多对一)
     * @param
     * @return {@link List<Student>}
     * @author why
     * @date 2021/8/6 15:36
     */

    public List<Student> getStudentTeach();
    /***结果嵌套
     * Desc:查询所有的学生信息以及对应的老师信息(一对一或者多对一)
     * @param
     * @return {@link List<Student>}
     * @author why
     * @date 2021/8/6 15:36
     */
    public List<Student> getStudentTeach1();

}
