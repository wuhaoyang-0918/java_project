package com.example.dao;

import com.example.pojo.Books;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author  why
 * @date  2021/9/20 10:15
 * @PackageName  com.example.dao
 * @description  
*/
@Mapper
public interface BooksMapper {
    /**
     * 插入
     * @author why
     * @date 2021/11/20 15:23
     * @param record
     * @return int
     */
    int insert(Books record);
}