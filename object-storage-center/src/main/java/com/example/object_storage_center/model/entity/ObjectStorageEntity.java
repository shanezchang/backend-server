package com.example.object_storage_center.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_object_storage")
public class ObjectStorageEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String filename;

    private String filenameExtension;

    private String filenameOriginal;

    private String contentType;

    private Long byteSize;

    private String encodeText;

    private Long visitTimes;

    private Integer deleteFlag;

    private Long createTime;

    private Long updateTime;
}
