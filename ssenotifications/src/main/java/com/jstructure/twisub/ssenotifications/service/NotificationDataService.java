package com.jstructure.twisub.ssenotifications.service;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;

public interface NotificationDataService {

    void add(NotificationDto notification);

    NotificationDto get(String to);

}
