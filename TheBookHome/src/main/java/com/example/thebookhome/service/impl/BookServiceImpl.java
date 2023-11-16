package com.example.thebookhome.service.impl;

import com.example.thebookhome.model.BookEntity;
import com.example.thebookhome.model.dto.AddBookDto;
import com.example.thebookhome.repository.BookRepository;
import com.example.thebookhome.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Base64;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void addBook(AddBookDto addBookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(addBookDto.getTitle());
        bookEntity.setAuthor(addBookDto.getAuthor());
        bookEntity.setCategory(addBookDto.getCategory());
        bookEntity.setDescription(addBookDto.getDescription());
        bookEntity.setPrice(addBookDto.getPrice());

        String fileName = StringUtils.cleanPath(addBookDto.getFile().getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("not a a valid file");
        }
        try {
            bookEntity.setImage(Base64.getEncoder().encodeToString(addBookDto.getFile().getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookRepo.save(bookEntity);
    }
}
