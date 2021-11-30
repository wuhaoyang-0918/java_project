package org.example;

import org.example.service.SomeService;
import org.example.service.impl.OtherService;
import org.example.service.impl.SomeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
      /*  SomeService someService = (SomeService) applicationContext.getBean("someService");*/
        OtherService otherService = (OtherService) applicationContext.getBean("otherService");
        otherService.doOther();
       /* someService.doSome();
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println(count);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/


    }
}
