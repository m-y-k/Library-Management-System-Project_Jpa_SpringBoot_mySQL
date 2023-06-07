package com.BackendProject.LibraryManagementSystem.Service.Implementation;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.BookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.BookResponseDto;
import com.BackendProject.LibraryManagementSystem.Entity.Author;
import com.BackendProject.LibraryManagementSystem.Entity.Book;
import com.BackendProject.LibraryManagementSystem.Repository.AuthorRepository;
import com.BackendProject.LibraryManagementSystem.Service.Interface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    public BookResponseDto addBook(BookRequestDto bookRequestDto){
        Author author = authorRepository.findById((bookRequestDto.getAuthorId())).get();
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIsissued(false);
        book.setAuthor(author);

        author.getBook().add(book);
        authorRepository.save(author);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;

    }
}
