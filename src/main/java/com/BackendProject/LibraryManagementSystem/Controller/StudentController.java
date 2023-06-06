package com.BackendProject.LibraryManagementSystem.Controller;

import com.BackendProject.LibraryManagementSystem.DTO.StudentRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.StudentResponseDto;
import com.BackendProject.LibraryManagementSystem.DTO.StudentUpdateEmailRequestDto;
import com.BackendProject.LibraryManagementSystem.Entity.Student;
import com.BackendProject.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
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
