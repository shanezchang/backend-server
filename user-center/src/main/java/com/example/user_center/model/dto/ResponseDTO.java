package com.example.user_center.model.dto;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {

    private boolean success;

    private int code;

    private String message;

    private T data;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
