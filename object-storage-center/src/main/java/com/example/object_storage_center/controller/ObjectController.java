package com.example.object_storage_center.controller;

import com.example.object_storage_center.model.dto.ResponseDTO;
import com.example.object_storage_center.service.IObjectService;
import com.example.object_storage_center.util.ResponseUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/object")
@Slf4j
public class ObjectController {

    private final IObjectService objectService;

    public ObjectController(IObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping("/show_object")
    public void showObject(HttpServletResponse response, @RequestParam String filename) throws IOException {
        log.info("invoke show_object, req: {}", filename);
        objectService.showObject(response, filename);
    }

    @PostMapping("/upload_object")
    public ResponseDTO<Object> uploadObject(@RequestPart MultipartFile file) {
        log.info("invoke upload_object, req: {} - {} - {} - {}", file.getContentType(), file.getName(), file.getOriginalFilename(), file.getSize());
        return ResponseUtil.success(objectService.uploadObject(file));
    }
}
