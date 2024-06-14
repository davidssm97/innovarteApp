package com.application.rest.service;

import com.application.rest.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    Optional<Student> findByid(Integer studentId);

    void save(Student student);

    void deleteById(Integer studentId);
}
