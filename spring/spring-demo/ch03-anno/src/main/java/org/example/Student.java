package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 昊洋
 * @date:2021-07-30 12:29
 * @PackageName: org.example
 * @description:
 * @Version 1.0
 */
//不加默认是类名首字母小写
@Component
public class Student {
    @Value(value = "${name}")
    private  String name;
    @Value(value = "${age}")
    private  int age;
    @Autowired
    private School school;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
