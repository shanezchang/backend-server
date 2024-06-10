package com.example.object_storage_center.controller;

import com.example.object_storage_center.dto.ResponseDTO;
import com.example.object_storage_center.service.IObjectService;
import com.example.object_storage_center.util.ResponseUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/object")
@Slf4j
public class ObjectController {

    private final IObjectService objectService;

    public ObjectController(IObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping("/get_object")
    public ResponseDTO<Object> getObject(@RequestParam Long id) {
        log.info("invoke get_object, req: {}", id);
        objectService.getObject(id);
        return ResponseUtil.success();
    }

    @GetMapping("/show_object")
    public void showObject(HttpServletResponse response) throws IOException {
        // 将Base64编码的图片数据转换为字节数组
        String a = "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";
        byte[] imageBytes = Base64.getDecoder().decode(a);

        // 设置响应的内容类型为图片的MIME类型
        response.setContentType("image/jpeg");

        // 将字节数组写入响应的输出流中
        response.getOutputStream().write(imageBytes);
        response.getOutputStream().flush();
    }

    @PostMapping("/upload_object")
    public ResponseDTO<Object> uploadObject(@RequestPart MultipartFile file) {
        log.info("invoke upload_object, req: {}", file);
        log.info("{} - {} - {} - {}", file.getContentType(), file.getName(), file.getOriginalFilename(), file.getSize());
//        2024-06-11 00:47:40.360 - [http-nio-9999-exec-1] INFO  com.example.object_storage_center.controller.ObjectController - image/jpeg - file - Dingtalk_20240611003046.jpg - 6456
        try {
            String a = Base64.getEncoder().encodeToString(file.getBytes());
            log.info(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        objectService.uploadObject();
        return ResponseUtil.success();
    }
}