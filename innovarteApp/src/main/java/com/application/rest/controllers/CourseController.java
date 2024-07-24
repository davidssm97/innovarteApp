package com.application.rest.controllers;


import com.application.rest.controllers.dto.CourseDto;
import com.application.rest.entities.Courses;
import com.application.rest.entities.Student;
import com.application.rest.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> finById(@PathVariable Integer id) {
        Optional<Courses> coursesOptional = courseService.findByid(id);

        if (coursesOptional.isPresent()) {
            Courses courses = coursesOptional.get();
            CourseDto courseDto = CourseDto.builder()
                    .courseId(courses.getCourseId())
                    .courseName(courses.getCourseName())
                    .credits(courses.getCredits())
                    .descripcion(courses.getDescripcion())  // Nuevo campo
                    .professor(courses.getProfessor())
                    .enrollmentsList(courses.getEnrollmentsList())
                    .build();
            return ResponseEntity.ok(courseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<CourseDto> courseList = courseService.findAll()
                .stream()
                .map(courses -> CourseDto.builder()
                        .courseId(courses.getCourseId())
                        .courseName(courses.getCourseName())
                        .credits(courses.getCredits())
                        .descripcion(courses.getDescripcion())  // Nuevo campo
                        .enrollmentsList(courses.getEnrollmentsList())
                        .professor(courses.getProfessor())
                        .build()
                ).toList();
        return ResponseEntity.ok(courseList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CourseDto courseDto) throws URISyntaxException {
        if (courseDto.getCourseName().isBlank() || courseDto.getCredits() == null || courseDto.getProfessor() == null) {
            return ResponseEntity.badRequest().build();
        }
        Courses courses = Courses.builder()
                .courseName(courseDto.getCourseName())
                .credits(courseDto.getCredits())
                .descripcion(courseDto.getDescripcion())  // Nuevo campo
                .professor(courseDto.getProfessor())
                .enrollmentsList(courseDto.getEnrollmentsList())
                .courseId(courseDto.getCourseId())
                .build();
        courseService.save(courses);
        return ResponseEntity.created(new URI("/api/course")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
        Optional<Courses> coursesOptional = courseService.findByid(id);

        if (coursesOptional.isPresent()) {
            Courses courses = coursesOptional.get();
            courses.setCourseName(courseDto.getCourseName());
            courses.setCredits(courseDto.getCredits());
            courses.setDescripcion(courseDto.getDescripcion());  // Nuevo campo
            courses.setProfessor(courseDto.getProfessor());
            courseService.save(courses);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (id != null) {
            courseService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
