package com.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author why
 * @date 2021/10/27 17:44
 * @PackageName com.example
 * @description
 */
@DisplayName("断言测试")
@SpringBootTest
public class AssertionsTest {
    /**
     * 前面断言失败!下面代码不会执行
     */
    @DisplayName("简单断言")
    @Test
    void assertEquals1() {
        int cal = cal(2, 3);
        Assertions.assertEquals(6, cal, "期望值错误");
        System.out.println("上面断言发生错误!下面代码不会执行");
        final Object o = new Object();
        final Object o1 = new Object();

        Assertions.assertSame(o, o1, "两个对象不相等");

    }

    int cal(int i, int z) {
        return i + z;
    }

    @Test
    @DisplayName("数组断言")
    void array() {
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{3, 4}, "两个数组不相等");
    }

    /**
     * 需要断言全部成功
     */
    @Test
    @DisplayName("组合断言")
    void all() {
        Assertions.assertAll("test", () -> Assertions.assertTrue(true && true,"结果不为true"),
                //第一个是期望值,第二个是实际
                ()->Assertions.assertEquals(1,2,"结果不是2"));
    }
    /**
     * 异常断言
     *
     */
    @Test
    @DisplayName("异常断言")
    void testException(){
        //断定义务逻辑一定出现异常
        Assertions.assertThrows(ArithmeticException.class,()-> {int i=10/2;},"业务逻辑正常运行?");
    }
    /**
     * 快速失败
     */
    @Test
    @DisplayName("快速失败")
    void shouIdFail(){
        if(1==1){
            Assertions.fail("测试失败");
        }

    }
}

