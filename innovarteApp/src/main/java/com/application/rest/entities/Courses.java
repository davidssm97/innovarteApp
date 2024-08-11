package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Curso")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_curso")
    private Integer courseId;

    @Column(name = "Nombre_curso")
    private String courseName;

    @Column(name = "Creditos")
    private Integer credits;

    @Column(name = "Descripcion")
    private String descripcion;  // Nuevo campo

    @Column(name = "Imagen")
    private String imagen;  // Nuevo campo

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Enrollments> enrollmentsList = new ArrayList<>();



}
