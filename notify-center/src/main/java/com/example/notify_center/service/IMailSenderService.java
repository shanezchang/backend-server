package com.example.notify_center.service;

import com.example.notify_center.model.dto.MailSenderDTO;

public interface IMailSenderService {

    void send(MailSenderDTO dto);
}
