package com.why.test;

import com.why.exception.MyException;

/**
 * @author why
 * @date 2021/9/6 20:12
 * @PackageName com.why.test
 * @description
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("a");
        try{
            pp();
        }catch(MyException e){
            e.printStackTrace();
        }
        System.out.println("b");
    }
    public static void pp() throws  MyException {
        throw new MyException("自定义异常");
    }
}
