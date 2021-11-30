package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author why
 * @date 2021/10/21 20:17
 * @PackageName com.example.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Dog {
    private String name;
    private Integer age;
}