package com.application.rest.persistence;

import com.application.rest.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentDAO {
    List<Student> findAll();

    Optional <Student> findByid(Integer studentId);

    void save(Student student);

    void deleteById(Integer studentId);
}
