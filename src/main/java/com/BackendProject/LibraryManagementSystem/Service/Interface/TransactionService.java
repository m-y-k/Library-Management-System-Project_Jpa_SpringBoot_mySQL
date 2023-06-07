package com.BackendProject.LibraryManagementSystem.Service.Interface;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.IssueBookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

    }
