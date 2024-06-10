package com.example.object_storage_center.controller;

import com.example.object_storage_center.dto.ResponseDTO;
import com.example.object_storage_center.service.IObjectService;
import com.example.object_storage_center.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
