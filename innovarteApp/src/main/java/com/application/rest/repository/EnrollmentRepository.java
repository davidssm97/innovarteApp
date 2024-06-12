package com.application.rest.repository;

import com.application.rest.entities.Enrollments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollments,Integer> {
}
