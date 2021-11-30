package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The type User.
 *
 * @author why
 * @date 2021 /10/28 10:47
 * @PackageName com.example.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{



    private Long userid;
    private String userName;

}
