package com.wangzhongzhong.java.ai.langchain4j.configuration;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j.configuration
 * @className: MermoConfigurate
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 9:12
 * @version: 1.0
 */
@Configuration
public class MermoConfigurate {

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder().maxMessages(10).build();
    }
}
