package com.toluwase.appbackend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String emailOrUsername;
    private String password;
}
