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
@Table(name = "Estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_sstudiante")
    private Long studentId;

    @Column(name = "Nombre_estudiante")
    private String name;

    @Column(name = "Fecha_nacimiento")
    private LocalDate birthDate;

    @Column(name = "Correo")
    private String email;
}
