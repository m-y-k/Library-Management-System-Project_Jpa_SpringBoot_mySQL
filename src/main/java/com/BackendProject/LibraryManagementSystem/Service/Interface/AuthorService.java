package com.BackendProject.LibraryManagementSystem.Service.Interface;

import com.BackendProject.LibraryManagementSystem.Entity.Author;

import java.util.List;

public interface AuthorService {

    public void addAuthor(Author author);
    public List<Author> getAuthor();

}
