package com.application.rest.service;

import com.application.rest.entities.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    List<Professor> findAll();

    Optional<Professor> findByid(Integer professorId);

    void save(Professor professor);

    void deleteById(Integer professorId);
}
