package org.example;

import static org.junit.Assert.assertTrue;

import org.example.demo.ComplexAssembly;
import org.example.demo.Config;
import org.example.demo.Config1;
import org.example.demo.School1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
    /**
     * 属性赋值毛list set map array
     */
    @Test
    public void shouldAnswerWithTrue1()
    {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-1.xml");
        ComplexAssembly student = (ComplexAssembly) applicationContext.getBean("complexAssembly");
        System.out.println(student);
    }
    /**
     * 基于类配置文件
     */
    @Test
    public void shouldAnswerWithTrue2()
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexAssembly student = (ComplexAssembly) context.getBean("complexAssembly");
        System.out.println(student);
    }
    /**
     * 基于类配置文件
     */
    @Test
    public void shouldAnswerWithTrue3()
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        School1 school1 =context.getBean("school1",School1.class);
        System.out.println(school1);
    }
}
