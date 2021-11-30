package org.example.ch03;

/**
 * @author 昊洋
 * @date:2021-07-30 12:51
 * @PackageName: org.example
 * @description:
 * @Version 1.0
 */
public class School {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
