package com.restapi.service;

import com.restapi.model.UserDetailsRequest;
import com.restapi.model.UserRest;


public interface UserService {

    UserRest createUser(UserDetailsRequest userDetails);
}
