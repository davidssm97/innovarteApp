package com.application.rest.repository;

import com.application.rest.entities.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Courses,Integer> {
    List<Courses>findByCreditsBetween(Integer minPrice, Integer maxPrice);
}
