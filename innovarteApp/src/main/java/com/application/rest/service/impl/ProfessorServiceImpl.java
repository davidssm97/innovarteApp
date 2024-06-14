package com.application.rest.service.impl;

import com.application.rest.entities.Professor;
import com.application.rest.persistence.IProfessorDao;
import com.application.rest.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    private IProfessorDao professorDao;

    @Override
    public List<Professor> findAll() {
        return professorDao.findAll();
    }

    @Override
    public Optional<Professor> findByid(Integer professorId) {
        return professorDao.findByid(professorId);
    }

    @Override
    public void save(Professor professor) {
        professorDao.save(professor);
    }

    @Override
    public void deleteById(Integer professorId) {
        professorDao.deleteById(professorId);
    }
}
