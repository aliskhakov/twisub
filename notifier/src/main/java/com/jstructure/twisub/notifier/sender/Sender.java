package com.jstructure.twisub.notifier.sender;

import com.jstructure.twisub.notifier.dto.MessageDto;

public interface Sender {

    void send(MessageDto message);

}
