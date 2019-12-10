package com.jstructure.twisub.ssenotifications.api.v1;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import com.jstructure.twisub.ssenotifications.service.NotificationDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/notifications")
public class NotificationController {

    private final NotificationDataService notificationDataService;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody NotificationDto notification) {
        notificationDataService.add(notification);
    }

    @GetMapping(path = "/{to}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public NotificationDto get(@PathVariable String to) {
        return notificationDataService.get(to);
    }

    @CrossOrigin
    @GetMapping(path = "/{to}/sse/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NotificationDto> getSse(@PathVariable String to) {
        return notificationDataService.getFlux(to);
    }

}
