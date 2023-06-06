package com.BackendProject.LibraryManagementSystem.Service;

import com.BackendProject.LibraryManagementSystem.Entity.Author;
import com.BackendProject.LibraryManagementSystem.Entity.Book;
import com.BackendProject.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }


}
