package com.toluwase.appbackend.services.ServiceImpl;

import com.toluwase.appbackend.exception.ResourceNotFoundException;
import com.toluwase.appbackend.models.Todos;
import com.toluwase.appbackend.models.TodosRequest;
import com.toluwase.appbackend.models.Users;
import com.toluwase.appbackend.repositories.TodosRepository;
import com.toluwase.appbackend.repositories.UsersRepository;
import com.toluwase.appbackend.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodosServiceImpl implements TodosService {

    private TodosRepository todosRepository;
    private UsersRepository usersRepository;

    @Autowired
    public TodosServiceImpl(TodosRepository todosRepository, UsersRepository usersRepository) {
        this.todosRepository = todosRepository;
        this.usersRepository = usersRepository;
    }





    @Override
    public List<Todos> listAllTodos() {
        return this.todosRepository.findAll();
    }

    //get todos By ID
    @Override
    public Todos getTodosById (@PathVariable(value = "id") long todosId) {
        return this.todosRepository.findById(todosId).
                orElseThrow(()-> new ResourceNotFoundException("Todo with ID" + todosId +" not found"));
    }

    @Override
    public List<Todos> getTodosByUser (Users users) {
        return this.todosRepository.findAllByUsers(users);
    }

    //create a todos
    @Override
    public Todos addTodos (TodosRequest todosRequest) throws Exception {

        Todos todos = new Todos();
        todos.setTaskTitle(todosRequest.getTaskTitle());
        //todos.setPriority(todosRequest.getPriority());
        todos.setDescription(todosRequest.getDescription());
        todos.setStartDate(todosRequest.getStartDate());
        todos.setFinishDate(todosRequest.getFinishDate());
        todos.setUsers(todosRequest.getUsers());

        return todosRepository.save(todos);
    }


    //update todos
    @Override
    public Todos updateTodos (@RequestBody TodosRequest todos, @PathVariable("id") long todosId){
        Todos existingTodos = getTodosById(todosId);
        existingTodos.setDescription(todos.getDescription());
       // existingTodos.setPriority(todos.getPriority());
        existingTodos.setStartDate(todos.getStartDate());
        existingTodos.setFinishDate(todos.getFinishDate());
        existingTodos.setTaskTitle(todos.getTaskTitle());
        existingTodos.setUpdatedAt(LocalDateTime.now());
        return this.todosRepository.save(existingTodos);
    }


    @Override
    public void deleteTodos( @PathVariable("id") long todosId){
        var existingTodos = getTodosById(todosId);
        this.todosRepository.delete(existingTodos);
    }


    @Override
    public Page<Todos> findPaginated(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return todosRepository.findAll(pageable);
    }
}
