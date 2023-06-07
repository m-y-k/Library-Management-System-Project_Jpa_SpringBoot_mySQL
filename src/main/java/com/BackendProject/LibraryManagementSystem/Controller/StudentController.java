package com.BackendProject.LibraryManagementSystem.Controller;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;
import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentUpdateEmailRequestDto;
import com.BackendProject.LibraryManagementSystem.Service.Implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return "Student Added";
    }


    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }

}
