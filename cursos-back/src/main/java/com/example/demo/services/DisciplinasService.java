package com.example.demo.services;

import com.example.demo.controllers.dtos.DisciplinaDTO;
import com.example.demo.controllers.forms.DisciplinaForm;
import com.example.demo.models.Disciplina;
import com.example.demo.repositorys.DisciplinaRepository;
import com.example.demo.repositorys.specifications.DisciplinaSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class DisciplinasService {

    private final DisciplinaRepository repository;

    public DisciplinaDTO findById(Long id) {
        Disciplina d = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new DisciplinaDTO(d);
    }

    public void createDisciplina (DisciplinaForm form) {
        Disciplina d = new Disciplina(form);
        this.repository.save(d);
    }

    public void updateDisciplina (Long id, DisciplinaForm form) {
        Disciplina d = this.repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        d.update(form);
        repository.save(d);
    }

    public void deleteDisciplina (Long id) {
        Disciplina d = this.repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(d);
    }

    public Page<Disciplina> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Disciplina> findAll(Pageable pageable, String query) {
        return this.repository.findAll(DisciplinaSpecifications.likeGenericQuery(query), pageable);
    }

}

