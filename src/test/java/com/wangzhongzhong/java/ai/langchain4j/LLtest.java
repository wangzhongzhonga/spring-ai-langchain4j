package com.wangzhongzhong.java.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.QwenModelName;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
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

    @Autowired
    private QwenChatModel qwenChatModel;

  /*  @Autowired
    private ChatLanguageModel chatLanguageModel;
    @Test
    public void testGptDemo(){
        String chat = chatLanguageModel.chat("你是什么大模型");
        System.out.println("chatGptDemo = " + chat);
    }*/
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

    @Test
    public void testQwenDemo(){
        String chat = qwenChatModel.chat("你是什么大模型");
        System.out.println("qwenChatModel = " + chat);
    }

    @Test
    public void testPng(){
        WanxImageModel build = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-turbo")
                .apiKey("sk-ws-H.EMYMRHX.RxYS.MEYCIQCOYZXxNviaw1qoUfIg_yGrAmZshSTVva1Rzc0BtpwLVAIhAK6ysrwcio8qyN3lw0kW0MGaUkJgI0DBr8xDWrMkNnUN")
                .build();

        Response<Image> imageResponse = build.generate("狗");
        System.out.println(imageResponse.content().url());
    }
}
