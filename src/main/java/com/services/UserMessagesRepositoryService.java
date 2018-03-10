package com.services;

import com.Entity.Message;
import org.bson.Document;

import java.util.List;

/**
 * Created by mohibmanva on 10/03/18.
 */
public interface UserMessagesRepositoryService {
    void saveOrUpdate(Message message);

    void saveOrUpdateBulk(List<Message> messages);

    List<Message> find(Document query);
}
