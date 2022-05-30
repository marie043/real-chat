package dev.chat.producer.controller;

import dev.chat.producer.dto.ChatDto;
import dev.chat.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/chat")
    public String send(ChatDto chatDto) {
        log.debug("Produced: {}", chatDto.getMessage());
        producerService.send(chatDto.getMessage());
        return "redirect:/";
    }

}
