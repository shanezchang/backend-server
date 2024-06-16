package com.example.notify_center.controller;

import com.example.notify_center.model.dto.ResponseDTO;
import com.example.notify_center.util.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health")
    public ResponseDTO<Object> health() {
        return ResponseUtil.success();
    }
}
