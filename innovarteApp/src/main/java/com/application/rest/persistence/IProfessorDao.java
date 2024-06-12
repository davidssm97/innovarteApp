package com.application.rest.persistence;

import com.application.rest.entities.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorDao {
    List<Professor> findAll();

    Optional<Professor> findByid(Integer professorId);

    void save(Professor professor);

    void deleteById(Integer professorId);
}
