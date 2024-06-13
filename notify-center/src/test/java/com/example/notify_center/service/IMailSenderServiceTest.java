package com.example.notify_center.service;

import com.example.notify_center.model.dto.MailSenderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "dev")
class IMailSenderServiceTest {

    @Autowired
    private IMailSenderService mailSenderService;

    @Test
    void send() {
        MailSenderDTO dto = new MailSenderDTO();
        dto.setEmail("shane.z.chang@qq.com");
        dto.setBody("title");
        dto.setTitle("text");
        mailSenderService.send(dto);
    }
}