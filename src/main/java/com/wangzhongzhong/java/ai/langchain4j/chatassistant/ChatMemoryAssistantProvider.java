package com.wangzhongzhong.java.ai.langchain4j.chatassistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemory = "chatMemory", chatMemoryProvider = "chatMemoryProvider")
public interface ChatMemoryAssistantProvider {
    @SystemMessage("你是一个医疗助手，只能回答医疗相关的问题")
    String chat(@MemoryId int memoryId,@UserMessage String message);
}
