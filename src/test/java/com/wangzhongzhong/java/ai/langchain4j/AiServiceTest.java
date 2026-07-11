package com.wangzhongzhong.java.ai.langchain4j;

import com.wangzhongzhong.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
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
public class AiServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat(){
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        System.out.println("assistant.chat(\"\") = " + assistant.chat("你是什么大模型，能做什么"));
    }
}
