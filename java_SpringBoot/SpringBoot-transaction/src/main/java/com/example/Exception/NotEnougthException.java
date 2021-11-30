package com.example.Exception;

/**
 * @author why
 * @date 2021/9/20 11:03
 * @PackageName com.example.Exception
 * @description
 */
public class NotEnougthException extends RuntimeException{
    public NotEnougthException() {
        super();
    }
    public NotEnougthException(String message) {
        super(message);
    }
}
