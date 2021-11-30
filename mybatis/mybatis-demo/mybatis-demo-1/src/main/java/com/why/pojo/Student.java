package com.why.pojo;

import lombok.Data;

/**
 * @author 昊洋
 * @date:2021-08-06 15:28
 * @PackageName: com.why.pojo
 * @description:
 * @Version 1.0
 */
@Data
public class Student {
    private int id;
    private String name;
    /**
     * 多对一或者一对一
     * 每个学生需要关联一个老师
     */
    private Teacher teacher;

}
