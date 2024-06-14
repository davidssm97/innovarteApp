package com.application.rest.service.impl;

import com.application.rest.entities.Courses;
import com.application.rest.persistence.ICoursesDAO;
import com.application.rest.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICoursesDAO coursesDAO;

    @Override
    public List<Courses> findAll() {
        return coursesDAO.findAll();
    }

    @Override
    public Optional<Courses> findByid(Integer courseId) {
        return coursesDAO.findByid(courseId);
    }

    @Override
    public List<Courses> findBYCreditsInRange(Integer minPrice, Integer maxPrice) {
        return coursesDAO.findBYCreditsInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Courses courses) {
        coursesDAO.save(courses);
    }

    @Override
    public void deleteById(Integer courseId) {
        coursesDAO.deleteById(courseId);
    }
}
