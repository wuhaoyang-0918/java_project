package org.example;

import static org.junit.Assert.assertTrue;

import org.example.service.SomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest
{
    @Autowired
   private SomeService someService;
    /*
      前置通知
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        someService.doSome("1",2);
    }
    /*
      后置通知
     */
    @Test
    public void shouldAnswerWithTrue1()
    {
       String ab= someService.afterReturning("11");
    }
    /*
      环绕
     */
    @Test
    public void shouldAnswerWithTrue2()
    {
        String ab= someService.aroud("环绕");
        System.out.println("程序执行结果---->"+ab);
    }
    /*
     异常
    */
    @Test
    public void shouldAnswerWithTrue3()
    {
        someService.afterThrowing();

    }
    /*
    最终
    */
    @Test
    public void shouldAnswerWithTrue4()
    {
        someService.after();

    }
}
