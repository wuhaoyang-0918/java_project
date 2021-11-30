package com.why.pojo;

/**
 * @author why
 * @date 2021/9/7 16:38
 * @PackageName com.why.pojo
 * @description
 */
public abstract  class Anmid {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Anmid(int age) {
        this.age = age;
    }
    public Anmid(){
        System.out.println("父类无参构造方法");
    }
}
