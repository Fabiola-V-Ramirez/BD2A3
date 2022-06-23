package com.example.demo.services;

import com.example.demo.controllers.dtos.CursoDTO;
import com.example.demo.controllers.forms.CursoForm;
import com.example.demo.models.Curso;
import com.example.demo.repositorys.CursoRepository;
import com.example.demo.repositorys.specifications.CursoSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CursosService {
    private final CursoRepository repository;

    public CursoDTO findById(Long id) {
        Curso c = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CursoDTO(c);
    }

    public void createCurso (CursoForm form) {
        Curso c = new Curso(form);
        this.repository.save(c);
    }

    public void updateCurso (Long id, CursoForm form) {
        Curso c = this.repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        c.update(form);
        repository.save(c);
    }

    public void deleteCurso (Long id) {
        Curso c = this.repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(c);
    }

    public Page<Curso> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Curso> findAll(Pageable pageable, String query) {
        return this.repository.findAll(CursoSpecifications.likeGenericQuery(query), pageable);
    }

}

