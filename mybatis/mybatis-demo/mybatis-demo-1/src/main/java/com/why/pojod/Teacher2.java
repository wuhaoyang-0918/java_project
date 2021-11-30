package com.why.pojod;

import com.why.pojo.Student;
import lombok.Data;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-06 15:29
 * @PackageName: com.why.pojo
 * @description:
 * @Version 1.0
 */
@Data
public class Teacher2 {
    private int id;
    private String name;
    /**
     * 一对多
     * 一个老师有多个学生
     */
    private List<Student> students;
}
