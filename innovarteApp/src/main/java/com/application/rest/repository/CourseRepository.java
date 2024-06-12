package com.application.rest.repository;

import com.application.rest.entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Courses,Integer> {
}
