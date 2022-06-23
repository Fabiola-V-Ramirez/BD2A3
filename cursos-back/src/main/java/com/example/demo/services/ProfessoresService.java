package com.example.demo.services;

import com.example.demo.controllers.dtos.ProfessorDTO;
import com.example.demo.controllers.forms.ProfessorForm;
import com.example.demo.models.Professor;
import com.example.demo.repositorys.ProfessorRepository;
import com.example.demo.repositorys.specifications.ProfessorSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProfessoresService {
    private final ProfessorRepository repository;

    public ProfessorDTO findByMatricula (Long matricula) {
        Professor p = this.repository.findByMatricula(matricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ProfessorDTO(p);
    }

    public void createProfessor (ProfessorForm form) {
        Professor p = new Professor(form);
        this.repository.save(p);
    }

    public void updateProfessor (Long matricula, ProfessorForm form) {
        Professor p = this.repository.findByMatricula(matricula).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        p.update(form);
        repository.save(p);
    }

    public void deleteProfessor (Long matricula) {
        Professor p = this.repository.findByMatricula(matricula).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(p);
    }

    public Page<Professor> findAll (Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Professor> findAll (Pageable pageable, String query) {
        return this.repository.findAll(ProfessorSpecifications.likeGenericQuery(query), pageable);
    }

}
