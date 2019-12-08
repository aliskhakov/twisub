package com.jstructure.twisub.emailsender.sevice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private String to;

    private String subject;

    private String text;

}
