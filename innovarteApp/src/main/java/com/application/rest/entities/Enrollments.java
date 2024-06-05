package com.application.rest.entities;

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
    private Long enrollmentID;

    @Column(name = "Fecha_matriucla")
    private LocalDate enrollmentDate;


}
