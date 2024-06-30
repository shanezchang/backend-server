package com.example.notify_center.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.example.notify_center.constant.enums.MailSendStatusEnum;
import com.example.notify_center.mapper.MailSendLogMapper;
import com.example.notify_center.model.entity.MailSendLogEntity;
import com.example.notify_center.service.intf.IMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RefreshScope
public class MailService implements IMailService {

    @Value("${spring.mail.username}")
    private String from;

    private final MailSendLogMapper mailSendLogMapper;

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender, MailSendLogMapper mailSendLogMapper) {
        this.mailSender = mailSender;
        this.mailSendLogMapper = mailSendLogMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean send(String to, String subject, String text) {
        // todo redis lock
        boolean result = false;
        long currentTime = System.currentTimeMillis();
        MailSendLogEntity entity = MailSendLogEntity.builder()
                .mailFrom(from)
                .mailTo(to)
                .message(JSONObject.toJSONString(subject) + "|" + JSONObject.toJSONString(text))
                .status(MailSendStatusEnum.SUCCESS.getCode())
                .createTime(currentTime)
                .updateTime(currentTime)
                .build();
        mailSendLogMapper.insert(entity);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            mailSender.send(message);
            result = true;
        } catch (Exception e) {
            entity.setException(JSONObject.toJSONString(e));
            entity.setStatus(MailSendStatusEnum.FAIL.getCode());
            mailSendLogMapper.updateById(entity);
        }
        return result;
    }

}
