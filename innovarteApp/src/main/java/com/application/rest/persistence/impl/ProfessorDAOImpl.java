package com.application.rest.persistence.impl;

import com.application.rest.entities.Professor;
import com.application.rest.persistence.IProfessorDao;
import com.application.rest.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfessorDAOImpl implements IProfessorDao {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return (List<Professor>) professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findByid(Integer professorId) {
        return professorRepository.findById(professorId);
    }

    @Override
    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public void deleteById(Integer professorId) {
        professorRepository.deleteById(professorId);
    }
}
