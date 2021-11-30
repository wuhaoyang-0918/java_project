package com.why.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 昊洋
 * @date:2021-08-05 11:38
 * @PackageName: com.why.pojo
 * @description:
 * @Version 1.0
 */
@Data
public class User implements Serializable{
    private int id;
    private  String name;
    private String pwd;
}
