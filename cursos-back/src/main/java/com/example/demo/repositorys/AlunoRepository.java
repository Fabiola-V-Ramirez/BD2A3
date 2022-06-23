package com.example.demo.repositorys;

import com.example.demo.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {

    @Query("SELECT a FROM Aluno a WHERE a.matricula =:matricula")
    Optional<Aluno> findByMatricula(Long matricula);

    @Query("SELECT a FROM Aluno a WHERE a.nome =:nome")
    Optional<Aluno> findByNome(String nome);

}
