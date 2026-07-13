package com.wangzhongzhong.java.ai.langchain4j;

import com.wangzhongzhong.java.ai.langchain4j.assistant.DocumentExtAgent;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Scanner;

@SpringBootTest
public class DocumentExtAgentTest {

    @Autowired
    private DocumentExtAgent documentExtAgent;


    @Test
    public void testDocumentExtract2() {
        Document document1 = FileSystemDocumentLoader.loadDocument("E:/knowledge/医院信息.md");
        Document document2 = FileSystemDocumentLoader.loadDocument("E:/knowledge/科室信息.md");
        Document document3 = FileSystemDocumentLoader.loadDocument("E:/knowledge/神经内科.md");

        String allContent = document1.text() + "\n\n" + document2.text() + "\n\n" + document3.text();


        System.out.print("> ");
        String userInput = "有哪些医生，全部列举出来";

        String prompt = "以下是文档内容：\n" + allContent + "\n\n用户问题：" + userInput;

        Flux<String> responseFlux = documentExtAgent.chat(prompt);
        List<String> chunks = responseFlux.collectList().block();

        if (chunks != null) {
            StringBuilder result = new StringBuilder();
            for (String chunk : chunks) {
                result.append(chunk);
            }
            System.out.println("回答：" + result);
        }
        System.out.println();


    }
}
