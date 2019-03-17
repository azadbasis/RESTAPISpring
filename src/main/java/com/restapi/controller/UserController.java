package com.restapi.controller;

import com.restapi.model.UserDetailsRequestModel;
import com.restapi.model.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {


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
        UserRest returnValue = new UserRest();
        returnValue.setEmail("azad@gmail.com");
        returnValue.setFirstName("Azharul");
        returnValue.setLastName("Islam");

        // return new ResponseEntity<UserRest>(HttpStatus.OK);
        // return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
        return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
        //
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
