package com.BackendProject.LibraryManagementSystem.Service.Implementation;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;
import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.StudentUpdateEmailRequestDto;
import com.BackendProject.LibraryManagementSystem.Entity.LibraryCard;
import com.BackendProject.LibraryManagementSystem.Entity.Student;
import com.BackendProject.LibraryManagementSystem.Enum.CardStatus;
import com.BackendProject.LibraryManagementSystem.Repository.StudentRepository;
import com.BackendProject.LibraryManagementSystem.Service.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto){
        // create student object;
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        // create a card object;
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setStatus(CardStatus.ACTIVATED);
        libraryCard.setStudent(student) ;
        student.setCard(libraryCard);

        studentRepository.save(student);
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){

        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

            Student updatestudent = studentRepository.save(student);

            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(updatestudent.getId());
            studentResponseDto.setName(updatestudent.getName());
            studentResponseDto.setEmail(updatestudent.getEmail());

            return studentResponseDto;
    }
}
