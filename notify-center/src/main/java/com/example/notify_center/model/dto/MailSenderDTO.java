package com.example.notify_center.model.dto;

import lombok.Data;

@Data
public class MailSenderDTO {

    private String email;

    private String title;

    private String body;
}
