package com.why.dao;

/**
 * @author why
 * @date 2021/9/22 13:08
 * @PackageName com.why.dao
 * @description
 */
public class Main {
    public static void main(String[] args) {

        new UserDao() {
            @Override
            public void print() {
                System.out.println("<1>");
            }
        }.print();

        UserDao userDao1 = new UserDao() {
            @Override
            public void print() {
                System.out.println("<1>");
            }
        };
        userDao1.print();

        ((UserDao) () -> System.out.println("<2>")).print();

        UserDao userDao = () -> System.out.println("<3>");
        userDao.print();


    }
}
