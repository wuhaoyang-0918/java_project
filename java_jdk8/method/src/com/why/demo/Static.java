package com.why.demo;

/**
 * @author why
 * @date 2021/9/23 14:28
 * @PackageName com.why.demo
 * @description
 */
public class Static {
  //  方法引入之静态引入
    public static void main(String[] args) {
      //  UserDao userDao = (a) -> Main.sho(a);

        UserDao userDao1 = Static::sho;
        userDao1.print(6);


    }
    public static  void sho(Integer a){
        System.out.println("<sho>");
    }
}
