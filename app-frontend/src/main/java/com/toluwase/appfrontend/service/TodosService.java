package com.toluwase.appfrontend.service;

import com.toluwase.appfrontend.model.TodosRequest;
import com.toluwase.appfrontend.model.Todos;
import com.toluwase.appfrontend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodosService {
    private RestTemplate restTemplate;

    @Autowired
    public TodosService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Todos> todosList() {
        return restTemplate.exchange("http://localhost:9091/todos/all", HttpMethod.GET, null, List.class).getBody();
    }


    public List<Todos> userTodosList(Users users) {
        HttpEntity<Users> entity = new HttpEntity<>(users);
        return restTemplate.exchange("http://localhost:9091/todos/usersTodo", HttpMethod.GET, entity, List.class).getBody();
    }

    public Todos addTodos(TodosRequest todosRequest) {
        HttpEntity<TodosRequest> entity = new HttpEntity<>(todosRequest);
        return restTemplate.exchange("http://localhost:9091/todos/add", HttpMethod.POST, entity, Todos.class).getBody();
    }

}
