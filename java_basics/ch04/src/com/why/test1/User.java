package com.why.test1;

import java.util.Objects;

/**
 * @author why
 * @date 2021/9/8 10:05
 * @PackageName com.why.test1
 * @description
 */
public class User {
    private String userName;
    private Integer id;

    public User(String userName, Integer id) {
        this.userName = userName;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, id);
    }
}
