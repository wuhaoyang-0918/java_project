package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author why
 * @date 2021/10/22 13:25
 * @PackageName com.example.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String username;

    private Integer age;

    private String address;
}
