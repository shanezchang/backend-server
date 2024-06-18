package com.example.notify_center.model.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;

@Data
public class SendMailDTO {

    @NotEmpty
    private String to;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String text;
}
