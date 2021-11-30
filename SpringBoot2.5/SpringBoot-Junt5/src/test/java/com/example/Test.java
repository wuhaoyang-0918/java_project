package com.example;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


/**
 * The type Test.
 *
 * @author why
 * @date 2021 /10/27 17:10
 * @PackageName com.example
 * @description
 */
@SpringBootTest
@DisplayName("Test单元测试")
public class Test {    //类上可以测试全部@test方法

    /**
     * Test display name.
     */
    @org.junit.jupiter.api.Test
    @DisplayName("测试testDisplayName()")
    void testDisplayName() {
        System.out.println("1");
    }

    /**
     * //当前方法不参与单元测试在测试全部方法生效
     */
    @Disabled
    @org.junit.jupiter.api.Test
    @DisplayName("测试test2()")
    void test2() {
        System.out.println("2");
    }

    /**
     * 规定方法超时时间，超出时间测试抛出异常
     *
     * @throws InterruptedException the interrupted exception
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @org.junit.jupiter.api.Test
    void testTimout() throws InterruptedException {
        Thread.sleep(600);
    }

    /**
     * 循环测试
     */
    @org.junit.jupiter.api.Test
    @RepeatedTest(5)
    void repeatedTest(){
        System.out.println("repeatedTest");
    }

    /**
     * 测试开始前执行
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("测试开始前执行");
    }

    /**
     * After each.
     */
    /*
    * 测试结束后执行
    */
    @AfterEach
    void afterEach() {
        System.out.println("测试结束后执行");
    }

    /**
     * 全部测试方法开始时执行
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("全部测试方法开始时执行-->需要运行类的测试");
    }



    @AfterAll
    static void afterAll() {
        /**
         * 全部测试方法结束后时执行
         */
        System.out.println("全部测试方法结束后时执行-->需要运行类的测试");
    }
}
