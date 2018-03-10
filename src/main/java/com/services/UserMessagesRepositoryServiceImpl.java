package com.services;

import com.Entity.Message;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohibmanva on 10/03/18.
 */
public class UserMessagesRepositoryServiceImpl implements UserMessagesRepositoryService {

    private static MongoCollection mongoCollection;

    static {
        MongoClient mongoClient = new MongoClient("localhost:27017");
        mongoCollection = mongoClient.getDatabase("MESSAGE_MONGO").getCollection("Messages");
    }

    @Override
    public void saveOrUpdate(Message message) {
        if (message.getId() != null) {
            mongoCollection.deleteOne(message.toDocument());
        }
        mongoCollection.insertOne(message.toDocument());
    }

    @Override
    public void saveOrUpdateBulk(List<Message> messages) {
        for (Message message : messages) {
            mongoCollection.deleteOne(message.toDocument());
            mongoCollection.insertOne(message.toDocument());
        }
    }

    @Override
    public List<Message> find(Document query) {
        List<Message> messages = new ArrayList<Message>();
        for (Object message : mongoCollection.find(query)){
            messages.add((Message) message);
        }
        return messages;
    }
}
