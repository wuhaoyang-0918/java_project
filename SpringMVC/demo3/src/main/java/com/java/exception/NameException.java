package com.java.exception;

/**
 * @author 昊洋
 * @date:2021-08-17 10:55
 * @PackageName: com.java.exception
 * @description:
 * @Version 1.0
 */
public class NameException extends  Exception{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
