package com.jstructure.twisub.emailsender.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendRequest {

    private String to;

    private String subject;

    private String text;

}
