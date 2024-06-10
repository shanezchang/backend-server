package com.example.object_storage_center.controller;

import com.example.object_storage_center.dto.ResponseDTO;
import com.example.object_storage_center.util.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health")
    public ResponseDTO<Object> health() {
        return ResponseUtil.success();
    }
}
