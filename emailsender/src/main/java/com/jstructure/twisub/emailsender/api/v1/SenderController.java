package com.jstructure.twisub.emailsender.api.v1;

import com.jstructure.twisub.emailsender.api.v1.request.SendRequest;
import com.jstructure.twisub.emailsender.repository.EmailRepository;
import com.jstructure.twisub.emailsender.sevice.EmailSender;
import com.jstructure.twisub.emailsender.sevice.MessageDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email/")
@RequiredArgsConstructor
public class SenderController {

    private final Logger LOGGER = LoggerFactory.getLogger(SenderController.class);

    private final EmailRepository emailRepository;

    private final EmailSender emailSender;

    @PostMapping(path = "send/", produces = "application/json")
    public void send(@RequestBody SendRequest request) {
        MessageDto message = new MessageDto();
        String email = emailRepository.get(request.getTo());
        if (email != null) {
            message.setTo(email);
            message.setSubject(request.getSubject());
            message.setText(request.getText());
            emailSender.send(message);
            LOGGER.debug(String.format("Message to '%s <%s>' has been sent.", request.getTo(), email));
        } else {
            LOGGER.error(String.format("Email address for '%s' not found.", request.getTo()));
        }
    }

}
