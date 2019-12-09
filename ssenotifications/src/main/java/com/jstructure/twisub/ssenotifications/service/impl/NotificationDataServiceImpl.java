package com.jstructure.twisub.ssenotifications.service.impl;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import com.jstructure.twisub.ssenotifications.repository.NotificationRepository;
import com.jstructure.twisub.ssenotifications.service.NotificationDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class NotificationDataServiceImpl implements NotificationDataService {

    private final NotificationRepository repository;

    @Override
    public void add(NotificationDto notification) {
        repository.set(notification.getTo(), notification.getText());
    }

    @Override
    public NotificationDto get(String to) {
        NotificationDto notification = new NotificationDto();
        notification.setText(repository.get(to));
        notification.setTo(to);
        repository.delete(to);
        return notification;
    }

    @Override
    public Flux<NotificationDto> getFlux(String to) {
        return Flux.interval(Duration.ofSeconds(5))
                .map(sequence -> get(to))
                .filter(n -> n.getText() != null);
    }

}
