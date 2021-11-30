package org.example.cho1;

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

    public Student(String name, int age, School school) {
        System.out.println("有参");
        this.name = name;
        this.age = age;
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
