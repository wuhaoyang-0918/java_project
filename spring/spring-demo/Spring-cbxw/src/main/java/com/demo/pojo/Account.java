package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author why
 * @date 2021/10/19 13:31
 * @PackageName com.demo.pojo
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private Double money;
}
