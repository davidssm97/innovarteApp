package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Matricula")

public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matricula_id")
    private Integer enrollmentID;

    @Column(name = "Fecha_matriucla")
    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    @JsonIgnore
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonIgnore
    private Student student;


}
