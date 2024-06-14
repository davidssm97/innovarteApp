package com.application.rest.service;

import com.application.rest.entities.Enrollments;

import java.util.List;
import java.util.Optional;

public interface IEnrollmentService {
    List<Enrollments> findAll();

    Optional<Enrollments> findByid(Integer enrollmentID);

    void save(Enrollments enrollments);

    void deleteById(Integer enrollmentID);
}
