package com.application.rest.entities;

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
    private Long courseId;

    @Column(name = "Nombre_curso")
    private String courseName;

    @Column(name = "Creditos")
    private Long credits;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Enrollments> enrollmentsList = new ArrayList<>();



}
