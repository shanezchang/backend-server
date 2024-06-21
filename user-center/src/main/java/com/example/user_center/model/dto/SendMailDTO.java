package com.example.user_center.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMailDTO {

    private String to;

    private String subject;

    private String text;
}
