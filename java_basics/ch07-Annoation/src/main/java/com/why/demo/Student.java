package com.why.demo;

/**
 * @author why
 * @date 2021/9/19 14:24
 * @PackageName com.why.demo
 * @description
 */
public class Student extends Person{
    public static void main(String[] args) {
        Class clazz = Student.class;
        //Student类是否有@HeritedApplication
        if(clazz.isAnnotationPresent(HeritedApplication.class)){
            System.out.println("true");
        }
    }
}
