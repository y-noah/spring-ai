package org.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;


@RestController
public class ChatDemoController {

    private final ChatClient chatClient;
    public ChatDemoController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

//    @GetMapping("/ai")
//    String generation(String userInput) {
//        return this.chatClient.prompt()  // prompt 提示词
//                .user(userInput) // user()方法将用户输入传递给 AI 模型
//                .call() // call()方法将用户输入传递给 AI 模型，并返回一个响应
//                .content(); // content()方法将 AI 模型的响应作为 返回String
//    }

//    ChatResponse generation(String userInput) {
//        return this.chatClient.prompt()
//                .user(userInput) // user()方法将用户输入传递给 AI 模型
//                .call() // call()方法将用户输入传递给 AI 模型，并返回一个响应
//                .chatResponse(); // chatResponse()方法将 AI 模型的响应作为 ChatResponse 对象返回
//    }

    @GetMapping(value = "/ai/chat", produces = "text/html;charset=utf-8") // 防止乱码
    Flux<String> generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .stream()
                .content();
    }

/*
* call() 返回值
call()在指定方法后ChatClient，响应类型有几种不同的选项。

String content()：返回响应的字符串内容

ChatResponse chatResponse()：返回ChatResponse包含多个代以及有关响应的元数据的对象，例如，使用了多少个令牌来创建响应。

entity()返回 Java 类型

entity(ParameterizedTypeReference<T> type)：用于返回Collection实体类型。

entity(Class<T> type)：用于返回特定的实体类型。

entity(StructuredOutputConverter<T> structuredOutputConverter)：用于指定a的实例StructuredOutputConverter，将a转换String为实体类型。



stream() 返回值
在指定stream()方法后ChatClient，响应类型有几个选项：

Flux<String> content()：返回Flux由AI模型生成的字符串。

Flux<ChatResponse> chatResponse()：返回Flux对象ChatResponse，其中包含有关响应的附加元数据。*/
}