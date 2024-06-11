package com.example.object_storage_center.constant.enums;


import lombok.Getter;

@Getter
public enum DeleteFlagEnum {

    NOT_DELETE(0),
    IS_DELETE(1);

    private final int code;

    DeleteFlagEnum(int code) {
        this.code = code;
    }

}
