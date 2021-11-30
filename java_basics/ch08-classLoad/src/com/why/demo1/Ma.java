package com.why.demo1;

/**
 * @author why
 * @date 2021/9/19 16:07
 * @PackageName com.why.demo1
 * @description
 */
public class Ma {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> studentClass = Student.class;

        Student student = new Student("123");
        Class<? extends Student> aClass = student.getClass();

        Class<?> aClass1 = Class.forName("com.why.demo1.Student");

        System.out.println(studentClass==aClass);//true
        System.out.println(aClass==aClass1);//true





    }
}
