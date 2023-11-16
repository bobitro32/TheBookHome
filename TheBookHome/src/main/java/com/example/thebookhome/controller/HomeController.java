package com.example.thebookhome.controller;

import com.example.thebookhome.model.BookEntity;
import com.example.thebookhome.model.enums.CategoriesEnum;
import com.example.thebookhome.repository.BookRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private BookRepository bookRepo;
    public HomeController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
    @GetMapping("/")
    @ResponseBody
    public ModelAndView homeGet(HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        List<BookEntity> books = bookRepo.findAll();

        long seed = System.nanoTime();
        Collections.shuffle(books, new Random(seed));
        mv.setViewName("index");
        mv.addObject("books",books);
        return mv;
    }
    @PostMapping(value = "/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }
}
