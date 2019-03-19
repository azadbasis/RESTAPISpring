package com.restapi.impl;

import com.restapi.model.UserDetailsRequest;
import com.restapi.model.UserRest;
import com.restapi.service.UserService;
import com.restapi.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        String userId = utils.genericUserId();
        returnValue.setUserId(userId);
        if (users == null)
            users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }
}
