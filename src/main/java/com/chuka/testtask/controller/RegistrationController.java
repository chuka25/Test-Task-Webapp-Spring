package com.chuka.testtask.controller;

import com.chuka.testtask.entity.UserEntity;
import com.chuka.testtask.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class RegistrationController {

    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";
    }
}
