package com.example.notify_center.service.impl;

import com.example.notify_center.model.dto.MailSenderDTO;
import com.example.notify_center.service.IMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements IMailSenderService {

//    @Value("${email.name}")
//    private String emailName;
//
//    @Value("${email.password}")
//    private String emailPassword;

    private final JavaMailSender mailSender;

    public MailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void main(String[] args) {
    }

    @Override
    public void send(MailSenderDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("garvinzhang@foxmail.com");
        message.setTo(dto.getEmail());
        message.setSubject(dto.getTitle());
        message.setText(dto.getBody());
        mailSender.send(message);
    }
}
