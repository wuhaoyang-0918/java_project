package org.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 昊洋
 * @date:2021-07-30 12:51
 * @PackageName: org.example
 * @description:
 * @Version 1.0
 */
public class School1 {
    @Value(value = "${name}")
    private  String name;

    @Value(value = "${age}")
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
