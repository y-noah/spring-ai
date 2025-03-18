package org.example.springai.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalModelController {


    @Autowired
    private OllamaChatModel ollamaChatModel;

    @GetMapping("/ai/local")
    public String local() {
        String prompt = "你始终用贴吧的语气回答问题。";
        String message =
                """
                 在windows环境中，部署大模型，为什么不能使用gpu加速
                """;
        String result = ollamaChatModel.call(prompt + ":" + message);

        return result;
    }

}
