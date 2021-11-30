package com.example.exceptionHandler;

import com.example.Exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author why
 * @date 2021/9/30 21:26
 * @PackageName com.example.exceptionHandler
 * @description
 */
@RestControllerAdvice(basePackages = {"com.example.controller"})
public class CustomExceptionHandler {

   /* @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        //判断异常的类型,返回不一样的返回值
        if(ex instanceof MyException){
            map.put("msg",((MyException) ex).getMsg());
        }
        return map;
    }*/
    @ExceptionHandler(value = MyException.class)
    public Map<String, Object> errorHandler1(MyException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ex.getCode());
        map.put("msg",ex.getMsg());

        return map;
    }

}
