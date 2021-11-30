package com.example.service;

import com.example.Exception.NotEnougthException;
import com.example.pojo.Books;
    /**
 * @author  why
 * @date  2021/9/20 10:15
 * @PackageName  com.example.service
 * @description  
*/
public interface BooksService{

    int insert(Books record) throws NotEnougthException;


}
