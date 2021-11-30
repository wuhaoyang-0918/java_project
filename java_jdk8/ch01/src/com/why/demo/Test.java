package com.why.demo;

/**
 * @author why
 * @date 2021/9/22 12:40
 * @PackageName com.why.demo
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserDao userDao=new UserDaoImpl();
        userDao.print();
        UserDao.printStatic();
        UserDao.printStatic();


    }
}
