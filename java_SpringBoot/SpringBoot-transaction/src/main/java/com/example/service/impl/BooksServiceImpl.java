package com.example.service.impl;

import com.example.dao.BooksMapper;
import com.example.pojo.Books;
import com.example.service.BooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author  why
 * @date  2021/9/20 10:15
 * @PackageName  com.example.service.impl
 * @description  
*/
@Service
public class BooksServiceImpl implements BooksService{

    @Resource
    private BooksMapper booksMapper;


    /**
     * 基于@Transactional自动事务
     * @param record
     * @return
     */
    /*@Override
    @Transactional
    public int insert(Books record){
        int insert = booksMapper.insert(record);
        try {
            int i= 5/0; //默认会抛出异常会回滚
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw new NotEnougthException("算术异常");
        }
        return insert;
    }*/
    @Override
    public int insert(Books record){
        return booksMapper.insert(record);
    }


}
