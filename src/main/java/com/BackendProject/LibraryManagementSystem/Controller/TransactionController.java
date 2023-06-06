package com.BackendProject.LibraryManagementSystem.Controller;

import com.BackendProject.LibraryManagementSystem.DTO.IssueBookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.IssueBookResponseDto;
import com.BackendProject.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/issue_book")
    public ResponseEntity issuebook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        IssueBookResponseDto issueBookResponseDto;
        try {
            issueBookResponseDto=transactionService.issuebook(issueBookRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(issueBookResponseDto, HttpStatus.ACCEPTED);


    }
}
