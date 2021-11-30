package com.why.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author why
 * @date 2021/8/23 22:25
 * @PackageName com.why.pojo
 * @description
 */
public class DateVo {

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")             //接受前端请求
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //响应给前端
    private Date date;

    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

}
