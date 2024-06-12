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
@Table(name = "Profesor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_profesor")
    private Integer professorId;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "Fecha_contratacion")
    private LocalDate hireDate;

    @Column(name = "Correo")
    private String email;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Courses> coursesList = new ArrayList<>();

}
