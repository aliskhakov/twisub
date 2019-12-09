package com.jstructure.twisub.notifier.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jstructure.twisub.notifier.dto.TweetDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TweetsDeserializer extends JsonDeserializer<List<TweetDto>> {

    @Override
    public List<TweetDto> deserialize(String topic, Headers headers, byte[] data) {
        return deserialize(topic, data);
    }

    @Override
    public List<TweetDto> deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, new TypeReference<List<TweetDto>>() {
            });
        } catch (IOException e) {
            throw new SerializationException("Can't deserialize data [" + Arrays.toString(data) +
                    "] from topic [" + topic + "]", e);
        }
    }

}
