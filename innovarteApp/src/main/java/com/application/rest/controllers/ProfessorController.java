package com.application.rest.controllers;

import com.application.rest.controllers.dto.ProfessorDto;
import com.application.rest.entities.Professor;
import com.application.rest.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    @GetMapping("/find/{professorId}")
    public ResponseEntity<?> findById(@PathVariable Integer professorId) {
        Optional<Professor> professorOptional = professorService.findByid(professorId);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();

            ProfessorDto professorDto = ProfessorDto.builder()
                    .professorId(professor.getProfessorId())
                    .name(professor.getName())
                    .hireDate(professor.getHireDate())
                    .email(professor.getEmail())
                    .coursesList(professor.getCoursesList())
                    .build();

            return ResponseEntity.ok(professorDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProfessorDto> professorList = professorService.findAll()
                .stream()
                .map(professor -> ProfessorDto.builder()
                        .professorId(professor.getProfessorId())
                        .name(professor.getName())
                        .hireDate(professor.getHireDate())
                        .email(professor.getEmail())
                        .coursesList(professor.getCoursesList())
                        .build())
                .toList();
        return ResponseEntity.ok(professorList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProfessorDto professorDto) throws URISyntaxException {

        if (professorDto.getName() == null || professorDto.getHireDate() == null || professorDto.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }

        Professor professor = Professor.builder()
                .name(professorDto.getName())
                .hireDate(professorDto.getHireDate())
                .email(professorDto.getEmail())
                .coursesList(professorDto.getCoursesList())
                .build();

        professorService.save(professor);

        return ResponseEntity.created(new URI("/api/professor/save")).build();
    }

    @PutMapping("/update/{professorId}")
    public ResponseEntity<?> updateProfessor(@PathVariable Integer professorId, @RequestBody ProfessorDto professorDto) {
        Optional<Professor> professorOptional = professorService.findByid(professorId);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            professor.setName(professorDto.getName());
            professor.setHireDate(professorDto.getHireDate());
            professor.setEmail(professorDto.getEmail());
            professor.setCoursesList(professorDto.getCoursesList());
            professorService.save(professor);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{professorId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer professorId) {
        if (professorId != null) {
            professorService.deleteById(professorId);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
