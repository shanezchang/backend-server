package com.example.notify_center.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.notify_center.exception.BusinessException;
import com.example.notify_center.model.dto.ResponseDTO;
import com.example.notify_center.model.dto.SendMailDTO;
import com.example.notify_center.service.intf.IMailService;
import com.example.notify_center.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {

    private final IMailService mailService;

    public MailController(IMailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseDTO<Object> send(@RequestBody @Validated SendMailDTO dto) {
        log.info("invoke send, req:{}", JSONObject.toJSONString(dto));
        if (!mailService.send(dto.getTo(), dto.getSubject(), dto.getText())) {
            throw new BusinessException("Send mail failed");
        }
        return ResponseUtil.success();
    }

}
