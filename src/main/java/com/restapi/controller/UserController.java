package com.restapi.controller;

import com.restapi.exceptions.UserServiceException;
import com.restapi.impl.UserServiceImpl;
import com.restapi.model.UpdateUserDetailsRequest;
import com.restapi.model.UserDetailsRequest;
import com.restapi.model.UserRest;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {


    private Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers
            (
                    @RequestParam(value = "page", defaultValue = "1") int page,
                    @RequestParam(value = "limit", defaultValue = "50") int limit,
                    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
            ) {
        return "get user was called with page = " + page + " and limit = " + limit + " and sort " + sort;
    }

    @GetMapping(path = "/{userId}",
            produces =
                    {MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                    })
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId) {

        // return new ResponseEntity<UserRest>(HttpStatus.OK);
        // return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
        if (true) throw new UserServiceException("A user service exception is thrown");
      /*  String firstName=null;
        int firstNameLength=firstName.length();*/

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(
            consumes =
                    {MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                    },
            produces =
                    {MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
        //
    }

    @PutMapping(path = "/{userId}", consumes =
            {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces =
                    {MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_JSON_VALUE
                    })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequest userDetails) {

        UserRest storeUserDetails = users.get(userId);
        storeUserDetails.setFirstName(userDetails.getFirstName());
        storeUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storeUserDetails);
        return storeUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
