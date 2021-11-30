package com.example.pojo;

import lombok.Data;

/**
 *@author 昊洋
 *@date:2021-02-07 11:09
 *@PackageName: com.example.pojo
 *@description: 
 *@Version 1.0
*/
@Data
public class Pet {
    private Integer id;

    private String name;



    public Pet(Integer id, String name) {
        this.id = id;
        this.name = name;

    }



}