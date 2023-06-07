package com.BackendProject.LibraryManagementSystem.Controller;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.BookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.BookResponseDto;
import com.BackendProject.LibraryManagementSystem.Service.Implementation.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}
