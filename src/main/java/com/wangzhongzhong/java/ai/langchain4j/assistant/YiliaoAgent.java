package com.wangzhongzhong.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j.assistant
 * @className: YIliaoAgent
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 16:07
 * @version: 1.0
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,
//        chatModel = "qwenChatModel",
        streamingChatModel = "qwenStreamingChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "yiliaoChatMemoryProvider",
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverYiliao2")
public interface YiliaoAgent {
    @SystemMessage(fromResource = "yiliao-system-message.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
