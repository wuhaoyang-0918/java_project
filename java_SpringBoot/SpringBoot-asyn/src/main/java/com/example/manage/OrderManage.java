package com.example.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author why
 * @date 2021/9/17 10:38
 * @PackageName com.example.manage
 * @description
 */
@Component
@Slf4j
public class OrderManage {
    @Async
   // @WhyAsyc
    public void asyncLog() {
        try {
            log.info(">目标方法开始执行 正在阻塞3s时间<");
            Thread.sleep(3000);
            log.info("<2>");
        } catch (Exception ignored) {

        }

    }

}
