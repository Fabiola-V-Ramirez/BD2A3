package com.example.demo.repositorys;

import com.example.demo.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>, JpaSpecificationExecutor<Professor> {

    @Query("SELECT a FROM Professor a WHERE a.matricula =:matricula")
    Optional<Professor> findByMatricula(Long matricula);

    @Query("SELECT a FROM Professor a WHERE a.nome =:nome")
    Optional<Professor> findByNome(String nome);

}
