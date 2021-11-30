package com.why.pojo;

/**
 * @author why
 * @date 2021/9/6 17:56
 * @PackageName com.why.pojo
 * @description
 */
public class Ma {
    public static void main(String[] args) {
       /* //Object>Person>Student
        //x instanceof y  能不能编译通过看是否父子关系(或者相同)
        Student student=new Student();
        System.out.println(student instanceof Student);//true
        System.out.println(student instanceof Object);//true
        System.out.println(student instanceof Person);//true
        System.out.println("===========================");
        Person person=new Student();
        ((Student)person).so();
        System.out.println(student instanceof Student);//true
        System.out.println(student instanceof Object);//true
        System.out.println(student instanceof Person);//true*/
        Zj zj=new Zj();
        Person person=new Student();
        Person person1=new Teacher();
        zj.show(person1);

    }
}
