package com.jstructure.twisub.emailsender.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jstructure.twisub.emailsender.dto.UserDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class UserDeserializer extends JsonDeserializer<UserDto> {

    @Override
    public UserDto deserialize(String topic, Headers headers, byte[] data) {
        return deserialize(topic, data);
    }

    @Override
    public UserDto deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, new TypeReference<UserDto>() {
            });
        } catch (IOException e) {
            throw new SerializationException("Can't deserialize data [" + Arrays.toString(data) +
                    "] from topic [" + topic + "]", e);
        }
    }

}
