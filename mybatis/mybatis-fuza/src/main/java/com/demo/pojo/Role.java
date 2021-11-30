package com.demo.pojo;

/**
 * @author why
 * @date 2021/10/20 15:09
 * @PackageName com.demo.pojo
 * @description
 */
public class Role {
    private Integer id;
    private String name;
    private String desc;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
    public Role() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Role(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
}
