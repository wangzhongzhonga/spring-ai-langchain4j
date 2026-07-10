package com.wangzhongzhong.java.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class LLtest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testGptDemo(){
        String chat = openAiChatModel.chat("你是什么大模型");
        System.out.println("chatGptDemo = " + chat);
    }
   @Test
    public void testSpringBoot(){
       OpenAiChatModel model = OpenAiChatModel.builder()
               .baseUrl("http://langchain4j.dev/demo/openai/v1")
               .apiKey("demo")
               .modelName("gpt-4o-mini")
               .build();
       String chat = model.chat("你好，你是什么大模型");
       System.out.println("chat = " + chat);
   }


}
