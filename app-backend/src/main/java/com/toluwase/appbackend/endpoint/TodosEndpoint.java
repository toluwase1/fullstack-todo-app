package com.toluwase.appbackend.endpoint;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.TodosRequest;
import com.toluwase.appbackend.models.Users;
import com.toluwase.appbackend.services.ServiceImpl.TodosServiceImpl;
import com.toluwase.appbackend.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosEndpoint {
    private TodosServiceImpl todosService;

    @Autowired
    public TodosEndpoint(TodosServiceImpl todosService) {
        this.todosService = todosService;
    }

    @RequestMapping("/all")
    public List<Todos> getAllTodos () {
        List<Todos> todosList = todosService.listAllTodos();
        return todosList;
    }

    @RequestMapping("/{id}")
    public Todos getTodosById (@PathVariable(value = "id") long todosId) {
        return this.todosService.getTodosById(todosId);
    }

    @RequestMapping("/usersTodo")
    public List<Todos> getTodosByUser(Users user) {
        return this.todosService.getTodosByUser(user);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTodos ( @RequestBody TodosRequest todos) throws Exception {
        todosService.addTodos(todos);
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }



}
