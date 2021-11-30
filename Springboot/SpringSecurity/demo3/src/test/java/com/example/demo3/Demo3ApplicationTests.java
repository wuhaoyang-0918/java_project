package com.example.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Demo3ApplicationTests {
   @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("昊洋");
        mailMessage.setText("测试邮箱");
        mailMessage.setTo("1648996479@qq.com");
        mailMessage.setFrom("1648996479@qq.com");
        mailSender.send(mailMessage);

    }
    @Test
    void contextLoads1() {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("昊洋");
        mailMessage.setText("测试邮箱");
        mailMessage.setTo("1648996479@qq.com");
        mailMessage.setFrom("1648996479@qq.com");
        mailSender.send(mailMessage);

    }

    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper Helper=new MimeMessageHelper(mimeMessage,true);
        Helper.setSubject("刘培祥");
        Helper.setText("<P style='color:red'>谢谢你狂神说JAVA系列课程~</p>",true);
        Helper.addAttachment("1.jpg",new File("c:\\user\\1.jpg"));
        Helper.setTo("1648996479@qq.com");
        //指名邮件发件人
        Helper.setFrom("1648996479@qq.com");
        mailSender.send(mimeMessage);
    }

}
