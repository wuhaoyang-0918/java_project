package com.example.testcontroll; 

import org.junit.Test;

/** 
* TestControl Tester. 
* 
* @author <Authors name> 
* @since <pre>06/23/2021</pre> 
* @version 1.0 
*/ 
public class TestControlTest { 




@Test
public void multiThreadTest(){
       new Thread(()->{
           System.out.println("1");
       },"11").start();
    new Thread(()->{
        System.out.println("2");
    },"22").start();
    System.out.println("3");
    System.out.println("4");

} 





}
