package com.why.test;

/**
 * @author why
 * @date 2021/9/19 17:34
 * @PackageName com.why.test
 * @description
 */
public class User {
    private Integer id;
    private String name;

    public User() {
        System.out.println("===我是无参构造方法被调用");
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Log(value = "查询")
    public String print(Integer id) {
        System.out.println("参数:"+id);
        return "" + id;
    }
}
