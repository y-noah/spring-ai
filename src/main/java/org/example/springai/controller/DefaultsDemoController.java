package org.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DefaultsDemoController {
    private final ChatClient chatClient;

    DefaultsDemoController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/simple")
//    public Map<String, String> completion(@RequestParam(value = "message", defaultValue = "给我一个笑话") String message) {
//        return Map.of("completion", this.chatClient.prompt().user(message).call().content());
//    }

    Map<String, String> completion(@RequestParam(value = "message", defaultValue = "给我一个笑话") String message, String role) {
        return Map.of("completion",
            this.chatClient.prompt()
                .system(sp -> sp.param("role", role))
                .user(message)
                .call()
                .content());
    }
}
