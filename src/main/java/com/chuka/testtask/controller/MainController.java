package com.chuka.testtask.controller;

import com.chuka.testtask.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    UserService userService;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("users", userService.getAll());
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
