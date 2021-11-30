package com.why.exception;

/**
 * @author why
 * @date 2021/9/6 21:23
 * @PackageName com.why.exception
 * @description
 */
public class MyException extends Exception{
    public MyException(String msg) {
        super(msg);
    }
    public MyException() {
        super();
    }
}
