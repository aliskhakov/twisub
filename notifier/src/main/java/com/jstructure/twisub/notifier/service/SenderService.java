package com.jstructure.twisub.notifier.service;

import com.jstructure.twisub.notifier.dto.MessageDto;

public interface SenderService {

    void send(MessageDto message);

}
