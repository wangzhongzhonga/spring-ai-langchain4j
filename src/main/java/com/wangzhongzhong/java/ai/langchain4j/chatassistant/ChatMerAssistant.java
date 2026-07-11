package com.wangzhongzhong.java.ai.langchain4j.chatassistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemory = "chatMemory")
public interface ChatMerAssistant {
    String chat(String userMessage);
}
