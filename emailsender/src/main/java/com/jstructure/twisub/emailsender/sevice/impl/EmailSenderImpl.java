package com.jstructure.twisub.emailsender.sevice.impl;

import com.jstructure.twisub.emailsender.sevice.EmailSender;
import com.jstructure.twisub.emailsender.sevice.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender emailSender;

    public void send(MessageDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getText());
        emailSender.send(message);
    }

}
