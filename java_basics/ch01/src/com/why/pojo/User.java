package com.why.pojo;

/**
 * @author why
 * @date 2021/9/4 14:04
 * @PackageName com.why.pojo
 * @description
 */
public class User {
    private String name;
    private int id;

    public User() {
        this("1",2);
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
