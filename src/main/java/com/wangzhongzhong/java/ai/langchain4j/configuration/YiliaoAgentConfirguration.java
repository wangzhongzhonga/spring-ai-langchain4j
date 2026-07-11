package com.wangzhongzhong.java.ai.langchain4j.configuration;

import com.wangzhongzhong.java.ai.langchain4j.chatstore.ChatMemoryMongoStore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j.configuration
 * @className: YiliaoAgentConfirguration
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 16:15
 * @version: 1.0
 */
@Configuration
public class YiliaoAgentConfirguration {

    @Autowired
    private ChatMemoryMongoStore chatMemoryMongoStore;

    @Bean
    public ChatMemoryProvider yiliaoChatMemoryProvider() {
        return new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .maxMessages(100)
                        .chatMemoryStore(chatMemoryMongoStore)
                        .id(memoryId)
                        .build();
            }
        };
    }
}
