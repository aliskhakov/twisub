package com.jstructure.twisub.notifier.service;

import com.jstructure.twisub.notifier.dto.MessageDto;

public interface NotifierService {

    void notify(MessageDto message);

}
