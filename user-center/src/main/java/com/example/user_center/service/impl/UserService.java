package com.example.user_center.service.impl;

import com.example.user_center.model.dto.SendMailDTO;
import com.example.user_center.service.feign.NotifyCenterService;
import com.example.user_center.service.intf.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements IUserService {

    private final NotifyCenterService notifyCenterService;

    public UserService(NotifyCenterService notifyCenterService) {
        this.notifyCenterService = notifyCenterService;
    }

    @Override
    public void sendVerifyCode() {
        notifyCenterService.send(SendMailDTO.builder()
                .to("shane.z.chang@hotmail.com")
                .text("text")
                .subject("subject")
                .build());
    }
}
