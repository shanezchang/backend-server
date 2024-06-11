package com.example.object_storage_center.config.exception;

import com.example.object_storage_center.model.dto.ResponseDTO;
import com.example.object_storage_center.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseDTO<Object> exceptionHandler(BusinessException e) {
        log.error("BusinessException: ", e);
        return ResponseUtil.error(e.getCode(), e.getMessage(), e.getData());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseDTO<Object> exceptionHandler(Exception e) {
        log.error("InnerException: {}", e.getMessage());
        return ResponseUtil.error(e.getMessage());
    }

}
