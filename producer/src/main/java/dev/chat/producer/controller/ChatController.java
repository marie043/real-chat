package dev.chat.producer.controller;

import dev.chat.producer.dto.ChatDto;
import dev.chat.producer.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public String home(ChatDto chatDto, Model model) throws IOException {
        List<String> chatLogs = chatService.getChatLogs();

        model.addAttribute("chatDto", chatDto);
        model.addAttribute("chatLogs", chatLogs);

        return "home";
    }

}
