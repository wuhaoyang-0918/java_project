package com.why.mapper;



import com.why.pojod.Teacher2;
import org.apache.ibatis.annotations.Param;

/**
 * @author 昊洋
 * @date:2021-08-06 15:30
 * @PackageName: com.why.mapper
 * @description:
 * @Version 1.0
 */
public interface TeacherMapper {

    /***
     * Desc: 获取指定老师下的所有学生及老师的信息
     * @param id
     * @return {@link Teacher2}
     * @author why
     * @date 2021/8/6 16:59
     */


    Teacher2 getTeacher(@Param("tid") int id);
}
