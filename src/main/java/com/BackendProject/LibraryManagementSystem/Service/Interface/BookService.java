package com.BackendProject.LibraryManagementSystem.Service.Interface;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.BookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.BookResponseDto;

public interface BookService {

    public BookResponseDto addBook(BookRequestDto bookRequestDto);
}
