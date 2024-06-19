package com.application.rest.controllers.dto;

import com.application.rest.entities.Courses;
import com.application.rest.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentDto {

    private Integer enrollmentID;
    private LocalDate enrollmentDate;
    private Courses courses;
    private Student student;

}
