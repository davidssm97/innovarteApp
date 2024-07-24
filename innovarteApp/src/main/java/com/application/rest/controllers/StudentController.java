package com.application.rest.controllers;


import com.application.rest.controllers.dto.StudentDto;
import com.application.rest.entities.Student;
import com.application.rest.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<StudentDto> studentList = studentService.findAll()
                .stream()
                .map(student -> StudentDto.builder()
                        .studentId(student.getStudentId())
                        .name(student.getName())
                        .birthDate(student.getBirthDate())
                        .email(student.getEmail())
                        .enrollmentsList(student.getEnrollmentsList())
                        .paymentList(student.getPaymentList())
                        .build())
                .toList();
        return ResponseEntity.ok(studentList);

    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) throws URISyntaxException {

        if (studentDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        studentService.save(Student.builder()
                .name(studentDto.getName())
                .build());

        return ResponseEntity.created(new URI("/api/student/save")).build();

    }


    @PutMapping("/update/{studentId}")
    public ResponseEntity<?>updateStudent(@PathVariable Integer studentId, @RequestBody StudentDto studentDto){

        Optional<Student> studentOptional = studentService.findByid(studentId);

        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(studentDto.getName());
            studentService.save(student);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer studentId){

        if (studentId != null){
            studentService.deleteById(studentId);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();

    }




}
