package com.jstructure.twisub.ssenotifications.api.v1;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import com.jstructure.twisub.ssenotifications.service.NotificationDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/notifications")
public class NotificationController {

    private final NotificationDataService notificationDataService;

    @PostMapping(path = "/", produces = "application/json")
    public void add(@RequestBody NotificationDto notification) {
        notificationDataService.add(notification);
    }

    @GetMapping(path = "/{to}/", produces = "application/json")
    public NotificationDto get(@RequestParam String to) {
        return notificationDataService.get(to);
    }

}
