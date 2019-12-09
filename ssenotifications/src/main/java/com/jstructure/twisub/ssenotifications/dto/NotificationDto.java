package com.jstructure.twisub.ssenotifications.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NotificationDto implements Serializable {

    private String to;

    private String text;

}
