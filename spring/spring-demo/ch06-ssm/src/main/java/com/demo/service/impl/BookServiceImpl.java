package com.demo.service.impl;

import com.demo.dao.BookMapper;
import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-01 16:55
 * @PackageName: com.demo.service.impl
 * @description:
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    public int addBook(Books books) {
        //调用dao层的方法
        return bookMapper.addBook(books);
    }

    public int deleteBookByID(int id) {
        //调用dao层的方法
        return bookMapper.deleteBookByID(id);
    }

    public int updateBook(Books books) {
        //调用dao层的方法
        return bookMapper.updateBook(books);
    }

    public Books queryByID(int id) {
        //调用dao层的方法
        return bookMapper.queryByID(id);
    }

    public List<Books> queryAllBooks() {
        //调用dao层的方法
        return bookMapper.queryAllBooks();
    }
}
