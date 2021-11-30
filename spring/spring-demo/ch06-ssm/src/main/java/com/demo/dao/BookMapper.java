package com.demo.dao;

import com.demo.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@author 昊洋
 *@date:2021-08-01 16:09
 *@PackageName: com.demo.dao
 *@description: 
 *@Version 1.0
*/

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    //@Param注解指定传入参数的名称
    int deleteBookByID(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    //@Param注解指定传入参数的名称
    Books queryByID(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBooks();
}
