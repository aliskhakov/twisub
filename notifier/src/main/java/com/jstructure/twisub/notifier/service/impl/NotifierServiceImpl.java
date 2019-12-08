package com.jstructure.twisub.notifier.service.impl;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.service.NotifierService;
import com.jstructure.twisub.notifier.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotifierServiceImpl implements NotifierService {

    @Autowired
    @Qualifier("emailSenderServiceImplBean")
    private SenderService emailSender;

    @Override
    public void notify(MessageDto message) {
        emailSender.send(message);
    }

}
