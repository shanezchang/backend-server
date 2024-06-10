package com.example.object_storage_center.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_object_storage")
public class ObjectStorageEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer suffix;

    private String dataName;

    private Long dataSize;

    private String dataString;

    private Integer deleteFlag;

    private Long createTime;

    private Long updateTime;
}
