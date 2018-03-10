package com.services;

import com.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mohibmanva on 10/03/18.
 */

@Service
public class UserAccessProviderServiceImpl implements UserAccessProviderService {

    @Autowired
    UserCredentialMongoRepositoryService userCredentialMongoRepositoryService = new UserCredentialMongoRepositoryServiceImpl();

    @Override
    public boolean validateByUserEmail(String userEmail, Long passwordHash) {
        User user = userCredentialMongoRepositoryService.getUserByUserMailID(userEmail);
        if (user != null) {
            Long hash = user.getPasswordHash();
            System.out.println("hashing value" + hash);
            return passwordHash.equals(hash);
        }
        return false;
    }

    @Override
    public boolean registerUser(User user) {
        synchronized (this) {
            User userFound = userCredentialMongoRepositoryService.getUserByUserMailID(user.getUserEmail());
            if (userFound != null) {
                return false;
            }
            userFound = userCredentialMongoRepositoryService.getUserByUserName(user.getUserName());
            if (userFound != null) {
                return false;
            }
            userCredentialMongoRepositoryService.saveUser(user);
        }
        return true;
    }
}
