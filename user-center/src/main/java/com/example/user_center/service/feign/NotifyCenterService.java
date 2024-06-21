package com.example.user_center.service.feign;

import com.example.user_center.model.dto.ResponseDTO;
import com.example.user_center.model.dto.SendMailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(value = "notify-center")
public interface NotifyCenterService {
    @PostMapping("/mail/send")
    ResponseDTO<Object> send(@RequestBody SendMailDTO dto);
}
