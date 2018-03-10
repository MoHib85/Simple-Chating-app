package com.Entity;

import com.sun.tools.javadoc.DocImpl;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.Document;

import java.io.Serializable;

/**
 * Created by mohibmanva on 09/03/18.
 */

public class User implements Serializable {
    static private Long serialVersionUID = 42L;

    private String id = null;

    private final String userEmail;

    private final Long passwordHash;

    private final String userName;

    public User(String id, String userEmail, String userName, Long passwordHash) {
        this.id = id;
        this.userEmail = userEmail;
        this.userName = userName;
        this.passwordHash = passwordHash;
    }

    public User(String userEmail, Long passwordHash, String userName) {
        this.userEmail = userEmail;
        this.passwordHash = passwordHash;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Long getPasswordHash() {
        return passwordHash;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getId() {
        return id;
    }

    public static User fromDocument(Document doc) {
        //String id = (String) doc.get("_id");
        String userEmail = (String) doc.get("userEmail");
        String userName = (String) doc.get("userName");
        Long passwordhash = (Long) doc.get("passwordHash");
        return new User(null, userEmail, userName, passwordhash);
    }

    public Document getDocument() {
        Document doc = new Document();
        if (id != null) {
            doc.append("_id", id);
        }
        doc.append("userEmail", userEmail);
        doc.append("userName", userName);
        doc.append("passwordHash", passwordHash);
        return doc;
    }
}
