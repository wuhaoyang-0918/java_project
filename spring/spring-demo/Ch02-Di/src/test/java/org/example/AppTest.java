package org.example;

import static org.junit.Assert.assertTrue;

import org.example.ch03.SpringContextUtils;
import org.example.cho1.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * set注入
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        /*ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
         Student someService = (Student) applicationContext.getBean("student");
        System.out.println(someService);*/
    }
    /**
     * 构造注入
     */
    @Test
    public void shouldAnswerWithTrue1()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
      Student student = (Student)applicationContext.getBean("student2");
        System.out.println(student);
    }
    /**
     * 引用类型自动注入 byName
     */
    @Test
    public void shouldAnswerWithTrue2()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        org.example.ch02.Student student=(org.example.ch02.Student) applicationContext.getBean("student02");
        System.out.println(student);
    }
    /**
     * 引用类型自动注入 @Autowired
     */
    @Test
    public void shouldAnswerWithTrue3()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        org.example.ch03.Student student=(org.example.ch03.Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
