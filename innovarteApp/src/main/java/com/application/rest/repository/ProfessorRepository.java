package com.application.rest.repository;

import com.application.rest.entities.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor,Integer> {
}
