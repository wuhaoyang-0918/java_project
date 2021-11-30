package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author why
 * @date 2021/11/8 15:03
 * @PackageName com.example.entity
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant implements Serializable {
    private Integer id;
    private String name;
}
