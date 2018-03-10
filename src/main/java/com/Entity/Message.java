package com.Entity;

import org.bson.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by mohibmanva on 10/03/18.
 */
public class Message implements Serializable {

    private static final Long serialVersionUID = 52L;

    private String id;

    private final String messageContent;

    private final Date messageCreationTime;

    private final List<User> users;

    public Message(String id, String messageContent, Date messageCreationTime, List<User> users) {
        this.id = id;
        this.messageContent = messageContent;
        this.messageCreationTime = messageCreationTime;
        this.users = users;
    }

    public Message(String messageContent, Date messageCreationTime, List<User> users) {
        this.messageContent = messageContent;
        this.messageCreationTime = messageCreationTime;
        this.users = users;
    }

    public static Message getMessage(Document document) {
        return new Message((String) document.get("_id"), (String)document.get("messagContent"),
                                (Date) document.get("messageCreationTime"),(List<User>) document.get("users"));
    }

    public Document toDocument() {
        Document document = new Document();
        if (id != null) {
            document.append("_id", id);
        }
        document.append("messageContent", messageContent);
        document.append("messageCreationTime", messageCreationTime);
        return document;
    }

    public String getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }
}
