package com.services;

import com.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by mohibmanva on 09/03/18.
 */

@Service
public interface UserCredentialMongoRepositoryService {

    public User getUserByUserName(String userName);

    public User getUserByUserMailID(String userEmail);

    public void saveUser(User user);
}
