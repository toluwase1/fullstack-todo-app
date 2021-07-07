package com.toluwase.appfrontend.service;

import com.toluwase.appfrontend.model.Login;
import com.toluwase.appfrontend.model.Todos;
import com.toluwase.appfrontend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String signup (Users users)  {
        HttpEntity <Users> entity = new HttpEntity<>(users);
        return restTemplate.exchange("http://localhost:9091/user/create", HttpMethod.POST, entity, String.class).getBody();
    }

    public Users login (Login login)  {
        HttpEntity <Login> entity = new HttpEntity<>(login);
        return restTemplate.exchange("http://localhost:9091/user/login", HttpMethod.POST, entity, Users.class).getBody();
    }


    public Users getUser(String name){
        HttpEntity <String> entity = new HttpEntity<>(name);
        return restTemplate.exchange("http://localhost:9091/user/getUser", HttpMethod.POST, entity, Users.class).getBody();

    }

}
