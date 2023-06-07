package com.BackendProject.LibraryManagementSystem.DTO.ResponseDto;

import com.BackendProject.LibraryManagementSystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;
}
