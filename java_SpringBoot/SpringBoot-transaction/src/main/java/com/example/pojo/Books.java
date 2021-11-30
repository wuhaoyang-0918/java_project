package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  why
 * @date  2021/9/20 10:15
 * @PackageName  com.example.pojo
 * @description  
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    /**
    * 书id
    */
    private Integer bookID;

    /**
    * 书名
    */
    private String bookName;

    /**
    * 数量
    */
    private Integer bookCounts;

    /**
    * 描述
    */
    private String detail;
}