package org.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatDemoAdvisorController {

    @Autowired
    private ChatMemory chatMemory;

    @Autowired
    private ChatModel chatModel;

    @GetMapping("/ai/advisor")
    String getAdvice(String userInput) {
        return ChatClient.builder(chatModel)
                .build()
                .prompt()
                .advisors(
                        new MessageChatMemoryAdvisor(chatMemory)
                )
                .user(userInput)
                .call()
                .content();
    }




/*
* InMemoryChatMemory
内存
轻量快速，重启丢失
开发测试环境
RedisChatMemory
Redis
持久化存储，支持分布式
生产环境集群部署
JdbcChatMemory
数据库
结构化存储，便于分析
需要审计日志的场景*/
}
