package com.toluwase.appbackend.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String username;
}
