package com.example.object_storage_center.dto;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(title = "响应模型DTO")
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
