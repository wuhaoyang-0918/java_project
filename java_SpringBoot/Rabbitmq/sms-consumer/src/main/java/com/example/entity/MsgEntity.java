package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author why
 * @date 2021/11/17 10:50
 * @PackageName com.example.entity
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgEntity implements Serializable {
    private String msgId;
    private String userId;
    private String phone;
    private String email;
}

