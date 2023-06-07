package com.BackendProject.LibraryManagementSystem.Service.Interface;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentUpdateEmailRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;

public interface StudentService {

    public void addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto);

    }
