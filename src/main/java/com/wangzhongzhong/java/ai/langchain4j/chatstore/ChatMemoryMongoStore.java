package com.wangzhongzhong.java.ai.langchain4j.chatstore;

import com.wangzhongzhong.java.ai.langchain4j.dao.ChatMessages;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Collections;
import java.util.List;

/**
 * @projectName: spring-ai-langchain4j
 * @package: com.wangzhongzhong.java.ai.langchain4j.chatstore
 * @className: ChatMemoryMongoStore
 * @author: wangzhongzhong
 * @description: TODO
 * @date: 2026/7/11 15:23
 * @version: 1.0
 */
@Configuration
public class ChatMemoryMongoStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        Query query = new Query(Criteria.where("memoryId").is(memoryId));
        ChatMessages doc = mongoTemplate.findOne(query, ChatMessages.class);
        if (doc == null || doc.getContent() == null) {
            return Collections.emptyList();
        }
        return ChatMessageDeserializer.messagesFromJson(doc.getContent());
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        Query query = new Query(Criteria.where("memoryId").is(memoryId));
        mongoTemplate.upsert(query, new Update().set("content", ChatMessageSerializer.messagesToJson(list)), ChatMessages.class);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        Query query = new Query(Criteria.where("memoryId").is(memoryId));
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
