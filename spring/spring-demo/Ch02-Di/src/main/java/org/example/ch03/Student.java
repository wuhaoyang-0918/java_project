package org.example.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author 昊洋
 * @date:2021-07-30 12:29
 * @PackageName: org.example
 * @description:
 * @Version 1.0
 */
public class Student {
    private  String name;
    private  int age;
   /* @Autowired
    @Qualifier(value = "school2")
    private School school;*/

    @Resource(name = "school2")
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



    public  Student(){
    System.out.println("无参");
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
