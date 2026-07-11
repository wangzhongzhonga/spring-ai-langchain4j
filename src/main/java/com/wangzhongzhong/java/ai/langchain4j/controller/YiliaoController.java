package com.wangzhongzhong.java.ai.langchain4j.controller;

import com.wangzhongzhong.java.ai.langchain4j.assistant.YiliaoAgent;
import com.wangzhongzhong.java.ai.langchain4j.dao.ChatForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j.controller
 * @className: YiliaoController
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 17:49
 * @version: 1.0
 */
@RestController
@RequestMapping("/yiliao")
public class YiliaoController {

    @Autowired
    private YiliaoAgent yiliaoAgent;
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return yiliaoAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
