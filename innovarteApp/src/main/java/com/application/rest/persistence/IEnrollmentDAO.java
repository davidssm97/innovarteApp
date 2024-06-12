package com.application.rest.persistence;

import com.application.rest.entities.Enrollments;
import com.application.rest.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IEnrollmentDAO {
    List<Enrollments> findAll();

    Optional<Enrollments> findByid(Integer enrollmentID);

    void save(Enrollments enrollments);

    void deleteById(Integer enrollmentID);
}
