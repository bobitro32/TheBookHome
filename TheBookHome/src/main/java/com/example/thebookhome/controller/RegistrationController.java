package com.example.thebookhome.controller;

import com.example.thebookhome.model.dto.UserRegistrationDto;
import com.example.thebookhome.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView register(@ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto){
        return  new ModelAndView("register");
    }
    @PostMapping("/users/register")
    public ModelAndView register(@ModelAttribute("userRegistrationDto") @Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }
        userService.register(userRegistrationDto);
        return  new ModelAndView("redirect:/");
    }
}
