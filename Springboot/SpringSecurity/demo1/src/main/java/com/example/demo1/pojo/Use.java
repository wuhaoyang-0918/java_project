package com.example.demo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 昊洋
 * @date:2020-07-19 15:21
 * @description: Use
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Use {
    private  Integer id;
    private  String userName;
    private  String password;
    private String perms;
}
