package org.example.springai.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelDemoController {

    @Autowired
    @Qualifier("openAiChatModel")
    private ChatModel chatModel;

    @GetMapping("/ai/model/chatM")
    public ChatResponse model(String msg) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        msg,
                        OpenAiChatOptions.builder()
                                .build()
                ));
        return response;
    }


    @GetMapping("/ai/model/multimodal")
    public String multimodal() {
        String response = ChatClient.create(chatModel).prompt()
                .user(u -> u.text("Explain what do you see on this picture?")
                        .media(MimeTypeUtils.IMAGE_PNG, new ClassPathResource("/20250318101131.png")))
                .call()
                .content();


        return response;
    }
}
