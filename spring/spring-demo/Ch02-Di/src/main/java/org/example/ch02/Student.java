package org.example.ch02;

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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
