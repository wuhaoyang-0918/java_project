package com.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author why
 * @date 2021/9/30 9:35
 * @PackageName com.example.task
 * @description
 */
@Component
@Slf4j
public class ScheduledTasks {
    @Async
    @Scheduled(cron ="0/1 * * * * ? ")
    public void taskService() {
        try {
            log.info("<任务开始执行>" + System.currentTimeMillis());
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("<任务结束执行>" + System.currentTimeMillis());
    }
}
