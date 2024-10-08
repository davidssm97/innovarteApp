package com.application.rest.controllers.dto;

import com.application.rest.entities.Enrollments;
import com.application.rest.entities.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private Integer courseId;
    private String courseName;
    private Integer credits;
    private String descripcion;  // Nuevo campo
    private String imagen;  // Nuevo campo
    private Professor professor;
    private List<Enrollments> enrollmentsList = new ArrayList<>();

}
