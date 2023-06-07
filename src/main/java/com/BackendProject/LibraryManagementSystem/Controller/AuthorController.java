package com.BackendProject.LibraryManagementSystem.Controller;

import com.BackendProject.LibraryManagementSystem.Entity.Author;
import com.BackendProject.LibraryManagementSystem.Service.Implementation.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return "Author Added";
    }
    @GetMapping()
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }
}
