package dev.chat.producer.service;

import global.constant.ChatConstant;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    public List<String> getChatLogs() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ChatConstant.LOG_FILE));

        List<String> chatLogs = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            chatLogs.add(line);
        }

        return chatLogs;
    }

}
