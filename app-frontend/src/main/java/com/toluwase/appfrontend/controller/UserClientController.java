package com.toluwase.appfrontend.controller;

import com.toluwase.appfrontend.model.Users;
import com.toluwase.appfrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserClientController {
    @Autowired
    private UserService userService;


    public String signup(@RequestBody Users users) {


    }
}
