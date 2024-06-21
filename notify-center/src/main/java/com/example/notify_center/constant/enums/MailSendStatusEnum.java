package com.example.notify_center.constant.enums;


import lombok.Getter;

@Getter
public enum MailSendStatusEnum {

    FAIL(0),
    SUCCESS(1);

    private final int code;

    MailSendStatusEnum(int code) {
        this.code = code;
    }

}
