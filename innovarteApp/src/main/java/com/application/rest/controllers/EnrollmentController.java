package com.application.rest.controllers;

import com.application.rest.controllers.dto.EnrollmentDto;
import com.application.rest.entities.Enrollments;
import com.application.rest.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;

    @GetMapping("/find/{enrollmentId}")
    public ResponseEntity<?> findById(@PathVariable Integer enrollmentId) {
        Optional<Enrollments> enrollmentOptional = enrollmentService.findByid(enrollmentId);

        if (enrollmentOptional.isPresent()) {
            Enrollments enrollment = enrollmentOptional.get();

            EnrollmentDto enrollmentDto = EnrollmentDto.builder()
                    .enrollmentID(enrollment.getEnrollmentID())
                    .enrollmentDate(enrollment.getEnrollmentDate())
                    .courses(enrollment.getCourses())
                    .student(enrollment.getStudent())
                    .build();

            return ResponseEntity.ok(enrollmentDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<EnrollmentDto> enrollmentList = enrollmentService.findAll()
                .stream()
                .map(enrollment -> EnrollmentDto.builder()
                        .enrollmentID(enrollment.getEnrollmentID())
                        .enrollmentDate(enrollment.getEnrollmentDate())
                        .courses(enrollment.getCourses())
                        .student(enrollment.getStudent())
                        .build())
                .toList();
        return ResponseEntity.ok(enrollmentList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EnrollmentDto enrollmentDto) throws URISyntaxException {

        if (enrollmentDto.getEnrollmentDate() == null || enrollmentDto.getCourses() == null || enrollmentDto.getStudent() == null) {
            return ResponseEntity.badRequest().build();
        }

        enrollmentService.save(Enrollments.builder()
                .enrollmentDate(enrollmentDto.getEnrollmentDate())
                .courses(enrollmentDto.getCourses())
                .student(enrollmentDto.getStudent())
                .build());

        return ResponseEntity.created(new URI("/api/enrollment/save")).build();
    }

    @PutMapping("/update/{enrollmentId}")
    public ResponseEntity<?> updateEnrollment(@PathVariable Integer enrollmentId, @RequestBody EnrollmentDto enrollmentDto) {
        Optional<Enrollments> enrollmentOptional = enrollmentService.findByid(enrollmentId);

        if (enrollmentOptional.isPresent()) {
            Enrollments enrollments = enrollmentOptional.get();
            enrollments.setEnrollmentDate(enrollmentDto.getEnrollmentDate());
            enrollments.setCourses(enrollmentDto.getCourses());
            enrollments.setStudent(enrollmentDto.getStudent());
            enrollmentService.save(enrollments);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{enrollmentId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer enrollmentId) {
        if (enrollmentId != null) {
            enrollmentService.deleteById(enrollmentId);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}