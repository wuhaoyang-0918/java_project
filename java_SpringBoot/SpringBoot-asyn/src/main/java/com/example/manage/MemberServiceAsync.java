package com.example.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author why
 * @date 2021/9/30 20:22
 * @PackageName com.example.manage
 * @description
 */
@Component
@Slf4j
public class MemberServiceAsync {
    @Async
    public String sms() {
        log.info(">02<");
        try {
            log.info(">正在发送短信..<");
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        log.info(">03<");
        return "短信发送完成!";
    }
}
