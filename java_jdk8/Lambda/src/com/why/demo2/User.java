package com.why.demo2;

/**
 * @author why
 * @date 2021/9/22 15:06
 * @PackageName com.why.demo2
 * @description
 */
public class User {
    public User(Integer id) {
        this.id = id;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
