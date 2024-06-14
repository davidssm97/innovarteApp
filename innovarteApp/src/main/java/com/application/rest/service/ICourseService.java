package com.application.rest.service;

import com.application.rest.entities.Courses;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Courses> findAll();

    Optional<Courses> findByid(Integer courseId);

    List<Courses> findBYCreditsInRange(Integer minPrice, Integer maxPrice);

    void save(Courses courses);

    void deleteById(Integer courseId);
}
