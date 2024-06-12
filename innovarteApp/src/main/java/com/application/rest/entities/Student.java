package com.application.rest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "Id_studiante")
    private Integer studentId;

    @Column(name = "Nombre_estudiante")
    private String name;

    @Column(name = "Fecha_nacimiento")
    private LocalDate birthDate;

    @Column(name = "Correo")
    private String email;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Enrollments>enrollmentsList = new ArrayList<>();

    @OneToMany(mappedBy = "student1", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Payment>paymentList = new ArrayList<>();
}
