package org.example.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
    // 在类中创建ChatClient具有默认系统文本的@Configuration可简化运行时代码
    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("使用{role}的口吻回答")
                .build();
    }

}
