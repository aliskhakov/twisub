package com.jstructure.twisub.ssenotifications.service;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import reactor.core.publisher.Flux;

public interface NotificationDataService {

    void add(NotificationDto notification);

    NotificationDto get(String to);

    Flux<NotificationDto> getFlux(String to);

}
