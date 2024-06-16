package com.example.notify_center.controller;

import com.example.notify_center.model.dto.ResponseDTO;
import com.example.notify_center.model.dto.SendMailDTO;
import com.example.notify_center.service.intf.IMailService;
import com.example.notify_center.util.ResponseUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    private final IMailService mailService;

    public MailController(IMailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseDTO<Object> send(@RequestBody @Validated SendMailDTO dto) {
        mailService.send(dto.getTo(), dto.getSubject(), dto.getText());
        return ResponseUtil.success();
    }

}
