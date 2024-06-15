package com.application.rest.controllers;


import com.application.rest.controllers.dto.StudentDto;
import com.application.rest.entities.Student;
import com.application.rest.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/find/{studentId}")
    public ResponseEntity<?> findById(@PathVariable Integer studentId){
        Optional<Student>studentOptional = studentService.findByid(studentId);

        if(studentOptional.isPresent()){
            Student student = studentOptional.get();

            StudentDto studentDto = StudentDto.builder()
                    .studentId(student.getStudentId())
                    .name(student.getName())
                    .birthDate(student.getBirthDate())
                    .email(student.getEmail())
                    .enrollmentsList(student.getEnrollmentsList())
                    .paymentList(student.getPaymentList())
                    .build();

            return ResponseEntity.ok(studentDto);

        }
        return ResponseEntity.notFound().build();
    }
}
