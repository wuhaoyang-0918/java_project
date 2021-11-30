package com.example.Exception;

import lombok.Data;

/**
 * @author why
 * @date 2021/9/30 21:15
 * @PackageName com.example.Exception
 * @description
 */
@Data
public class MyException  extends RuntimeException{
    private long code;
    private String msg;

    public MyException(Long code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg){
        super(msg);
        this.msg = msg;
    }

}
