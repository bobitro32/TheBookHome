package com.example.thebookhome.controller;

import com.example.thebookhome.model.dto.AddBookDto;
import com.example.thebookhome.model.enums.CategoriesEnum;
import com.example.thebookhome.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("categories")
    public CategoriesEnum[] categoriesEnums() {
        return CategoriesEnum.values();
    }

    @GetMapping("/book/add")
    public ModelAndView addBook(Model model){
        if(!model.containsAttribute("addBookDto")){
            model.addAttribute("addBookDto",AddBookDto.empty());
        }
        return new ModelAndView("add-book");
    }
    @PostMapping("/book/add")
    public ModelAndView addBook(@Valid AddBookDto addBookDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addBookDto", addBookDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return new ModelAndView("redirect:/book/add");
        }
        bookService.addBook(addBookDto);

        return new ModelAndView("redirect:/");
    }
}
