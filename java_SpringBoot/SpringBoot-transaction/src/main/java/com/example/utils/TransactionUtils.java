package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @author why
 * @date 2021/9/20 11:21
 * @PackageName com.example.utils
 * @description 手动开启事务
 */


@Component
public class TransactionUtils {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 开启事务
     */
    public TransactionStatus begin(){
        return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
    }
    /**
     * 提交事务
     */
    public void commit(TransactionStatus status){
        dataSourceTransactionManager.commit(status);

    }

    /**
     * 回滚事务
     */
    public void rollback(TransactionStatus status){
        dataSourceTransactionManager.rollback(status);

    }

}
