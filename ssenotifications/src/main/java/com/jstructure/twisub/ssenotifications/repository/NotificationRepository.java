package com.jstructure.twisub.ssenotifications.repository;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;

public interface NotificationRepository {

    void set(String to, NotificationDto notification);

    NotificationDto get(String to);

    void delete(String userId);

}
