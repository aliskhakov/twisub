package com.jstructure.twisub.emailsender.api.v1;

import com.jstructure.twisub.emailsender.api.v1.request.SendRequest;
import com.jstructure.twisub.emailsender.sevice.EmailSender;
import com.jstructure.twisub.emailsender.sevice.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email/")
@RequiredArgsConstructor
public class SenderController {

    private final EmailSender emailSender;

    @PostMapping(path = "send/", produces = "application/json")
    public void send(@RequestBody SendRequest request) {
        MessageDto message = new MessageDto();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getText());
        emailSender.send(message);
        System.out.println("Hello, world!");
    }

}
