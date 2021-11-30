package com.example.login1.service;

import java.util.Map;

/**
 * @author 昊洋
 * @date:2020-07-15 1:07
 * @description: SendSms
 * @version: 1.0
 */
public interface SendSms {
    public boolean send(String phoneNum,String code);
}
