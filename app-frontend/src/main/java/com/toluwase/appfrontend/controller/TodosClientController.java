package com.toluwase.appfrontend.controller;

import com.toluwase.appfrontend.model.TodosRequest;
import com.toluwase.appfrontend.model.Todos;
import com.toluwase.appfrontend.model.Users;
import com.toluwase.appfrontend.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/todos")
public class TodosClientController {
    @Autowired
    private TodosService todosService;

    @GetMapping("/list")
    public String dashboard(Model model,HttpSession session){
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/user/login";
        model.addAttribute(todosService.todosList());
        return "dashboard";
    }


    @GetMapping("/add")
    public String addTodo(HttpSession session,Model model){
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/user/login";
        model.addAttribute("todo", new Todos());
        return "addTodo";
    }

    @PostMapping("/add")
    public String addTodo(HttpSession session, Todos todos) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/user/login";

        String[] startTime = todos.getStartDate().split("-|T|:");
        String[] endTime = todos.getFinishDate().split("-|T|:");


        LocalDateTime start = LocalDateTime.of(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]),
                Integer.parseInt(startTime[2]), Integer.parseInt(startTime[3]), Integer.parseInt(startTime[4]));
        LocalDateTime finish = LocalDateTime.of(Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1]),
                Integer.parseInt(endTime[2]), Integer.parseInt(endTime[3]), Integer.parseInt(endTime[4]));

        TodosRequest todosRequest = new TodosRequest(todos.getTaskTitle(), todos.getDescription(), start, finish, (Users) userObj);


        todosService.addTodos(todosRequest);
        return "redirect:/user/dashboard";
    }


}
