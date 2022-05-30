package dev.chat.consumer.service;

import dev.chat.consumer.global.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ConsumerService {

    private final String FILE = "chat_log.txt";

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listen(String message) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE, true))) {
            bos.write((message + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        log.debug("Consumed message: {}", message);
    }

}