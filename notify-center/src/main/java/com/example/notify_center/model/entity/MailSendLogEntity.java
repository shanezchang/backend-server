package com.example.notify_center.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_mail_send_log")
public class MailSendLogEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String mailFrom;

    private String mailTo;

    private String message;

    private Integer status;

    private String exception;

    private Integer deleteFlag;

    private Long createTime;

    private Long updateTime;
}
