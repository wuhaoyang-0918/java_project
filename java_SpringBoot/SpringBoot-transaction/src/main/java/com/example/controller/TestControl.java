package com.example.controller;

import com.example.annotation.AopAnnotation;
import com.example.pojo.Books;
import com.example.service.BooksService;
import com.example.utils.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/9/20 9:58
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class TestControl {
    @Autowired
    private BooksService booksService;
    @Autowired
    private TransactionUtils transactionUtils;

    /**
     * 手动事务
     */
    @RequestMapping("/user1")
    public String manualTransaction() {
        TransactionStatus begin = null;
        Books books = new Books(2, "2", 2, "2");
        int insert = 0;
        try {
            begin = transactionUtils.begin();
            insert = booksService.insert(books);
            int i = 10 / 0;
            transactionUtils.commit(begin);
        } catch (Exception e) {
            e.printStackTrace();
            if (begin != null) {
                transactionUtils.rollback(begin);
            }

        }
        return insert > 0 ? "success" : "failure";
    }

    /**
     *  Transaction
     */
    @RequestMapping("/user2")
    public String annotation() {

        Books books = new Books(2, "2", 2, "2");

        return booksService.insert(books) > 0 ? "success" : "failure";
    }
    /**
     *  Aop+自定义注解事务
     */
    @AopAnnotation
    @RequestMapping("/user3")
    public String aopAnnotation() {
        Books books = new Books(2, "2", 2, "2");
        int insert = booksService.insert(books);
        int i = 10 / 0;
        return insert > 0 ? "success" : "failure";
    }

}
