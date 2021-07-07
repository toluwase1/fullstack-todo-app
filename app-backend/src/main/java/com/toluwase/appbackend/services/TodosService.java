package com.toluwase.appbackend.services;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.TodosRequest;
import com.toluwase.appbackend.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TodosService {
    Todos addTodos (TodosRequest todos) throws Exception;
    List<Todos> listAllTodos ();
    Todos getTodosById (long id);
    void deleteTodos (long id);
    Todos updateTodos (TodosRequest todos, long id);
    Page<Todos> findPaginated (int pageNumber, int pageSize);
     List<Todos> getTodosByUser (Users user);
}
