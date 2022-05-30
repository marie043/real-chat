package dev.chat.producer.service;

import global.constant.KafkaConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        System.out.printf("Produce message : %s%n", message);
        kafkaTemplate.send(KafkaConstant.TOPIC, message);
    }

}
