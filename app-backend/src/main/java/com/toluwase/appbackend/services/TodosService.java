package com.toluwase.appbackend.services;

import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.TodosRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TodosService {
    Todos addTodos (TodosRequest todos) throws Exception;
    List<Todos> listAllTodos ();
    Todos getTodosById (long id);
    void deleteTodos (long id);
    Todos updateTodos (TodosRequest todos, long id);
    Page<Todos> findPaginated (int pageNumber, int pageSize);
}
