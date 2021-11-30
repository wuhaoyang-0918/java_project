package com.example.exception;

import com.example.Result.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author why
 * @date 2021/10/23 11:43
 * @PackageName com.example.exception
 * @description
 */
@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handlerException(Exception e){
        //状态码是常量或者枚举
        return new ResponseResult(300,e.getMessage());
    }
}
