package com.example.thebookhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {

    @GetMapping("/categories")
    public String category(){
        return "category";
    }
}
