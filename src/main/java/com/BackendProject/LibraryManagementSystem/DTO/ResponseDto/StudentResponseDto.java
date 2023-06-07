package com.BackendProject.LibraryManagementSystem.DTO.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private int id;
    private String name;
    private String email;

}

