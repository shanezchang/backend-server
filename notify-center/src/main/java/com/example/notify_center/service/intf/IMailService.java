package com.example.notify_center.service.intf;

public interface IMailService {

    boolean send(String to, String subject, String text);

}
