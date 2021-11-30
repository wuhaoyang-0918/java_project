package com.why.demo2;

/**
 * @author why
 * @date 2021/9/23 14:47
 * @PackageName com.why.demo2
 * @description
 */
public class UserEntity {
    public UserEntity(){}
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
