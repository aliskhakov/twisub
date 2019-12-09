package com.jstructure.twisub.ssenotifications.service.impl;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import com.jstructure.twisub.ssenotifications.repository.NotificationRepository;
import com.jstructure.twisub.ssenotifications.service.NotificationDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationDataServiceImpl implements NotificationDataService {

    private final NotificationRepository repository;

    @Override
    public void add(NotificationDto notification) {
        repository.set(notification.getTo(), notification);
    }

    @Override
    public NotificationDto get(String to) {
        NotificationDto notification = repository.get(to);
        repository.delete(to);
        return notification;
    }

}
