package com.toluwase.appfrontend.controller;

import com.toluwase.appfrontend.model.Login;
import com.toluwase.appfrontend.model.Todos;
import com.toluwase.appfrontend.model.Users;
import com.toluwase.appfrontend.service.TodosService;
import com.toluwase.appfrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserClientController {
    @Autowired
    private UserService userService;

    @Autowired
    private TodosService todosService;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String login(Login login, HttpSession session) {

        Users user = userService.login(login);

        if(user == null){
            return "redirect:/login";
        }else{
            session.setAttribute("user", user);
            return "redirect:/user/dashboard";
        }
    }

    @PostMapping("/signup")
    public String signup( Users users) {
        userService.signup(users);
        return "redirect:/user/login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("userSignUp", new Users());
        return "signup";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/user/login";
        Users users = (Users)userObj;
        System.out.println(users.getId());
        System.out.println(users.getFirstName());
        model.addAttribute("todos", todosService.todosList());


//        System.out.println(ll.get(1));
        return "dashboard";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/user/login";
    }
}
