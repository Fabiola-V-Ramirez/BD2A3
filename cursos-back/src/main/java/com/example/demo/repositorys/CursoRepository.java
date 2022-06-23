package com.example.demo.repositorys;

import com.example.demo.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>, JpaSpecificationExecutor<Curso> {

    @Query("SELECT a FROM Curso a WHERE a.nome =:nome")
    Optional<Curso> findByNome(Long nome);

}
