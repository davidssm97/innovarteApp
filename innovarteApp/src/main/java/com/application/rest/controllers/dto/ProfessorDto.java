package com.application.rest.controllers.dto;
import com.application.rest.entities.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDto {

    private Integer professorId;
    private String name;
    private LocalDate hireDate;
    private String email;
    private List<Courses> coursesList = new ArrayList<>();


}
