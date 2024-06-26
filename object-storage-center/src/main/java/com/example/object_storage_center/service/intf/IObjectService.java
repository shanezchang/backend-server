package com.example.object_storage_center.service.intf;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IObjectService {

    String uploadObject(MultipartFile file);

    void showObject(HttpServletResponse response, String filename) throws IOException;

}
