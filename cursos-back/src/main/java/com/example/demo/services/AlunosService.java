package com.example.demo.services;

import com.example.demo.controllers.dtos.AlunoDTO;
import com.example.demo.controllers.forms.AlunoForm;
import com.example.demo.models.Aluno;
import com.example.demo.repositorys.AlunoRepository;
import com.example.demo.repositorys.specifications.AlunoSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AlunosService {

    private final AlunoRepository repository;

    public AlunoDTO findByMatricula(Long matricula) {
        Aluno a = this.repository.findByMatricula(matricula).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new AlunoDTO(a);
    }

    public AlunoDTO findByNome(String nome) {
        Aluno a = this.repository.findByNome(nome).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new AlunoDTO(a);
    }

    public void createAluno (AlunoForm form) {
        Aluno a = new Aluno(form);
        this.repository.save(a);
    }

    public void updateAluno (Long matricula, AlunoForm form) {
        Aluno a = this.repository.findByMatricula(matricula).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        a.update(form);
        repository.save(a);
    }

    public void deleteAluno (Long matricula) {
        Aluno a = this.repository.findByMatricula(matricula).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(a);
    }

    public Page<Aluno> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Aluno> findAll(Pageable pageable, String query) {
        return this.repository.findAll(AlunoSpecifications.likeGenericQuery(query), pageable);
    }

}
