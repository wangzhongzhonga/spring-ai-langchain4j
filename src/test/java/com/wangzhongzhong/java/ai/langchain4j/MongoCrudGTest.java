package com.wangzhongzhong.java.ai.langchain4j;

import com.wangzhongzhong.java.ai.langchain4j.dao.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.junit.jupiter.api.Test;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j
 * @className: MongoCrudGTest
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 15:03
 * @version: 1.0
 */
@SpringBootTest
public class MongoCrudGTest {

    @Autowired
    private MongoTemplate mongoTemplate;
  /*  @Test
    public void testMongo() {

        mongoTemplate.insert(new ChatMessages(null, "test"));
    }*/
}
