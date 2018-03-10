package com.services;

import com.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by mohibmanva on 09/03/18.
 */

@Service
public interface UserAccessProviderService {

    boolean validateByUserEmail(String userName, Long passwordHash);

    boolean registerUser(User user);
}
