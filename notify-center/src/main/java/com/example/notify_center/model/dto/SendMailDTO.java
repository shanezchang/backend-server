package com.example.notify_center.model.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Data
public class SendMailDTO {

    @NotEmpty
    @Length(min = 5, max = 64)
    private String to;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String text;
}
