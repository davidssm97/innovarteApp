package com.application.rest.service.impl;

import com.application.rest.entities.Student;
import com.application.rest.persistence.IStudentDAO;
import com.application.rest.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Optional<Student> findByid(Integer studentId) {
        return studentDAO.findByid(studentId);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void deleteById(Integer studentId) {
        studentDAO.deleteById(studentId);
    }
}
