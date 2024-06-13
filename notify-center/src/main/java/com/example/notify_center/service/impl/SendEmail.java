package com.example.notify_center.service.impl;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "shane.z.chang@hotmail.com";

        // 发件人电子邮箱
        String from = "garvinzhang@foxmail.com";

        // QQ邮箱SMTP服务器
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties properties = new Properties();

        // 设置邮件服务器
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");

        // 获取默认的Session对象
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("garvinzhang@foxmail.com", "cctdqyvmoecvbhbg");
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // 设置发件人
            message.setFrom(new InternetAddress(from));

            // 设置收件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // 设置邮件标题
            message.setSubject("这是邮件的主题！");

            // 设置邮件内容
            message.setText("这是邮件的内容。");

            // 发送消息
            Transport.send(message);
            System.out.println("邮件发送成功....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
