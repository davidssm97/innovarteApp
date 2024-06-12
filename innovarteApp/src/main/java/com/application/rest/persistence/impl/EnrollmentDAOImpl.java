package com.application.rest.persistence.impl;

import com.application.rest.entities.Enrollments;
import com.application.rest.persistence.IEnrollmentDAO;
import com.application.rest.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnrollmentDAOImpl implements IEnrollmentDAO {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollments> findAll() {
        return (List<Enrollments>) enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollments> findByid(Integer enrollmentID) {
        return enrollmentRepository.findById(enrollmentID);
    }

    @Override
    public void save(Enrollments enrollments) {
        enrollmentRepository.save(enrollments);

    }

    @Override
    public void deleteById(Integer enrollmentID) {
        enrollmentRepository.deleteById(enrollmentID);
    }
}
