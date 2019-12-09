package com.jstructure.twisub.ssenotifications.dto;

import lombok.Data;

@Data
public class NotificationDto {

    private String to;

    private String subject;

    private String text;

}
