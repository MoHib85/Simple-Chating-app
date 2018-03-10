package com.services;

import com.Entity.User;
import com.google.gson.Gson;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * Created by mohibmanva on 10/03/18.
 */

public class UserCredentialMongoRepositoryServiceImpl implements UserCredentialMongoRepositoryService {

    private static MongoCollection mongoCollection;
    Gson GSON = new Gson();

    static {
        MongoClient mongoClient = new MongoClient("localhost:27017");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("USER_MONGO");
        mongoCollection = mongoDatabase.getCollection("Users");
    }

    public User getUserByUserName(String userName) {

        Bson mongoQuery = new BsonDocument("userName", new BsonString(userName));
        User user = null;

        for (Object o : mongoCollection.find(mongoQuery)) {
            if (user != null) {
                throw new IllegalStateException("More Than One User Found for the same username!");
            }
            user = GSON.fromJson(((Document) o).toJson(), User.class);
        }

        return user;
    }

    public User getUserByUserMailID(String userEmail) {
        Document mongoQuery = new Document("userEmail", userEmail);
        User user = null;

        for (Object o : mongoCollection.find(mongoQuery)) {
            if (user != null) {
                throw new IllegalStateException("More Than One User Found for the same username!");
            }
            user = User.fromDocument((Document)o);
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public void saveUser(User user) {
        mongoCollection.insertOne(user.getDocument());
    }
}
