package com.example.object_storage_center.util;

import com.example.object_storage_center.model.dto.ResponseDTO;

public class ResponseUtil {

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(true, 0, null, data);
    }

    public static <T> ResponseDTO<T> error(int code, String message, T data) {
        return new ResponseDTO<>(false, code, message, data);
    }

    public static <T> ResponseDTO<T> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> ResponseDTO<T> error(String message) {
        return error(-1, message, null);
    }

    public static <T> ResponseDTO<T> success() {
        return success(null);
    }
}
