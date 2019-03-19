package com.restapi.impl;

import com.restapi.model.UserDetailsRequest;
import com.restapi.model.UserRest;
import com.restapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequest userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if (users == null)
            users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }
}
