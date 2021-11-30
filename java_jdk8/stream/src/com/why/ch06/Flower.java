package com.why.ch06;

/**
 * @author why
 * @date 2021/9/24 16:30
 * @PackageName com.why.ch06
 * @description
 */
public class Flower {
    private String red;
    private Integer id;

    public Flower(String red, Integer id) {
        this.red = red;
        this.id = id;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "red='" + red + '\'' +
                ", id=" + id +
                '}';
    }
}

