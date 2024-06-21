package com.example.user_center.controller;

import com.example.user_center.model.dto.ResponseDTO;
import com.example.user_center.service.intf.IUserService;
import com.example.user_center.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/send_verify_code")
    public ResponseDTO<Object> sendVerifyCode() {
        log.info("invoke sendVerifyCode");
        userService.sendVerifyCode();
        return ResponseUtil.success();
    }
}
