package com.application.rest.persistence.impl;

import com.application.rest.entities.Courses;
import com.application.rest.persistence.ICoursesDAO;
import com.application.rest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseDAOImpl implements ICoursesDAO {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Courses> findAll() {

        return (List<Courses>) courseRepository.findAll();
    }

    @Override
    public Optional<Courses> findByid(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public List<Courses> findBYCreditsInRange(Integer minPrice, Integer maxPrice) {
        return courseRepository.findByCreditsBetween(minPrice,maxPrice);
    }

    @Override
    public void save(Courses courses) {
        courseRepository.save(courses);

    }

    @Override
    public void deleteById(Integer courseId) {
        courseRepository.deleteById(courseId);

    }
}
