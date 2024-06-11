package com.example.object_storage_center.controller;

import com.example.object_storage_center.model.dto.ResponseDTO;
import com.example.object_storage_center.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "健康检查接口")
public class HealthController {

    @Operation(summary = "健康检查")
    @RequestMapping("/health")
    public ResponseDTO<Object> health() {
        return ResponseUtil.success();
    }
}
