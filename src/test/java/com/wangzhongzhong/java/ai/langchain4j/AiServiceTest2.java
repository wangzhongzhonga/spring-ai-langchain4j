package com.wangzhongzhong.java.ai.langchain4j;

import com.wangzhongzhong.java.ai.langchain4j.assistant.Assistant;
import com.wangzhongzhong.java.ai.langchain4j.chatassistant.ChatMemoryAssistantProvider;
import com.wangzhongzhong.java.ai.langchain4j.chatassistant.ChatMerAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j
 * @className: AiServiceTest
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 8:24
 * @version: 1.0
 */
@SpringBootTest
public class AiServiceTest2 {

    @Autowired
    private Assistant assistant;

    @Test
    public void testChat() {
        String chat = assistant.chat("你是谁");
        System.out.println("chat = " + chat);
        System.out.println("assistant.chat(\"\") = " + assistant.chat("你能用三个字解释地球吗"));
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory2() {
        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是齐天大圣");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage1.text());
        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,
                aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }
    @Test
    public void testMoreMe(){
        MessageWindowChatMemory memory = MessageWindowChatMemory.builder().maxMessages(10).build();
        Assistant assistant1 = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(memory)
                .build();

        String chat = assistant1.chat("我是王先生");
        System.out.println("chat = " + chat);
        System.out.println("assistant1 = " + assistant1.chat("你知道我是谁吗"));
    }

    @Autowired
    private ChatMerAssistant assistant1;
    @Test
    public void testMoreMe2(){
        String chat = assistant1.chat("我是zhangsan");
        System.out.println("chat = " + chat);
        System.out.println("assistant1 = " + assistant1.chat("你知道我是谁吗"));
    }

    @Autowired
    private ChatMemoryAssistantProvider chatMemoryAssistantProvider;
    @Test
    public void testChatMemory() {
        String chat = chatMemoryAssistantProvider.chat(1, "我是小四");
        System.out.println("chat = " + chat);
        System.out.println("chat = " + chatMemoryAssistantProvider.chat(1, "你知道我是谁吗"));
        System.out.println("chat2 = " + chatMemoryAssistantProvider.chat(2, "你知道我是谁吗"));

    }


    @Test
    public void testChatMemory3() {
        String chat = chatMemoryAssistantProvider.chat(3, "我是小四");
        System.out.println("chat = " + chat);
        System.out.println("chat = " + chatMemoryAssistantProvider.chat(3, "你知道我是谁吗"));
        System.out.println("chat2 = " + chatMemoryAssistantProvider.chat(4, "你知道我是谁吗"));

    }

}
