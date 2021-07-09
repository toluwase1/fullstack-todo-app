package com.toluwase.appfrontend.controller;

import com.toluwase.appfrontend.model.Login;
import com.toluwase.appfrontend.model.Test;
import com.toluwase.appfrontend.model.Todos;
import com.toluwase.appfrontend.model.Users;
import com.toluwase.appfrontend.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

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

        String[] startTime = todos.getStartDate().split("-|Time:|:");
        String[] endTime = todos.getFinishDate().split("-|Time:|:");


        LocalDateTime start = LocalDateTime.of(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]),
                Integer.parseInt(startTime[2]), Integer.parseInt(startTime[3]), Integer.parseInt(startTime[4]));
        LocalDateTime finish = LocalDateTime.of(Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1]),
                Integer.parseInt(endTime[2]), Integer.parseInt(endTime[3]), Integer.parseInt(endTime[4]));

        Test test = new Test(todos.getTaskTitle(), todos.getDescription(), start, finish, (Users) userObj);


        todosService.addTodos(test);
        return "redirect:/user/dashboard";
    }


}
