package com.application.rest.service.impl;

import com.application.rest.entities.Enrollments;
import com.application.rest.persistence.IEnrollmentDAO;
import com.application.rest.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {

    @Autowired
    private IEnrollmentDAO enrollmentDAO;

    @Override
    public List<Enrollments> findAll() {
        return enrollmentDAO.findAll();
    }

    @Override
    public Optional<Enrollments> findByid(Integer enrollmentID) {
        return enrollmentDAO.findByid(enrollmentID);
    }

    @Override
    public void save(Enrollments enrollments) {
        enrollmentDAO.save(enrollments);
    }

    @Override
    public void deleteById(Integer enrollmentID) {
        enrollmentDAO.deleteById(enrollmentID);
    }
}
