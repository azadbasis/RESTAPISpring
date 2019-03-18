package com.restapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequest {

    @NotNull(message = "First name can not be null")
    @Size(min = 2,message = "First name must not be less than  two characters")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(min = 2,message = "Last name must not be less than  two characters")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
