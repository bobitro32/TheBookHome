package com.example.thebookhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @PostMapping(value = "/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }
}
