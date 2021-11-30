package com.why.demo1;

/**
 * @author why
 * @date 2021/9/23 14:37
 * @PackageName com.why.demo1
 * @description
 */
public class Instance {
    public static void main(String[] args) {
        Instance mai=new Instance();
        //UserDao userDao  = () -> mai.sho();
        UserDao userDao  = mai::sho;
        System.out.println(userDao.print());//---->success
    }
    public String sho(){
        return "success";
    }
}
