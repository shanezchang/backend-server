package com.example.object_storage_center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.object_storage_center.config.exception.BusinessException;
import com.example.object_storage_center.constant.consist.CommonConsist;
import com.example.object_storage_center.constant.enums.DeleteFlagEnum;
import com.example.object_storage_center.mapper.ObjectStorageMapper;
import com.example.object_storage_center.model.entity.ObjectStorageEntity;
import com.example.object_storage_center.service.intf.IObjectService;
import com.example.object_storage_center.util.StringUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


@Service
@Slf4j
@RefreshScope
public class ObjectService implements IObjectService {

    @Value(value = "${serviceMachine.host}")
    private String urlHost;

    @Value(value = "${serviceMachine.port}")
    private String urlPort;

    private final ObjectStorageMapper objectStorageMapper;

    public ObjectService(ObjectStorageMapper objectStorageMapper) {
        this.objectStorageMapper = objectStorageMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadObject(MultipartFile file) {
        validateUploadObject(file);
        long currentTime = System.currentTimeMillis();
        try {
            String filename = StringUtil.getRandomString();
            String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String url = urlHost + ":" + urlPort + "/" + "object/show_object?filename=" + filename + "." + filenameExtension;
            this.objectStorageMapper.insert(ObjectStorageEntity.builder()
                    .filename(filename)
                    .filenameExtension(filenameExtension)
                    .filenameOriginal(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .byteSize(file.getSize())
                    .encodeText(Base64.getEncoder().encodeToString(file.getBytes()))
                    .visitTimes(0L)
                    .deleteFlag(DeleteFlagEnum.NOT_DELETE.getCode())
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .build());
            return url;
        } catch (IOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void showObject(HttpServletResponse response, String filename) throws IOException {
        if (Strings.isBlank(filename)) {
            throw new BusinessException("filename is blank");
        }
        LambdaQueryWrapper<ObjectStorageEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ObjectStorageEntity::getFilename, filename.substring(0, Math.min(32, filename.length())));
        ObjectStorageEntity entity = objectStorageMapper.selectOne(queryWrapper);
        if (entity == null) {
            throw new BusinessException("filename is not exist");
        }
        if (entity.getDeleteFlag() == DeleteFlagEnum.IS_DELETE.getCode()) {
            throw new BusinessException("file is deleted");
        }
        response.setContentType(entity.getContentType());
        response.getOutputStream().write(Base64.getDecoder().decode(entity.getEncodeText()));
        response.getOutputStream().flush();

        // update visit times
        entity.setUpdateTime(System.currentTimeMillis());
        entity.setVisitTimes(entity.getVisitTimes() + 1);
        objectStorageMapper.updateById(entity);
    }

    private void validateUploadObject(MultipartFile file) {
        if (file.getSize() > CommonConsist.OneMbSize * 8) {
            throw new BusinessException("object size is too large");
        }
    }

}
