package com.example.demo.repositorys;

import com.example.demo.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>, JpaSpecificationExecutor<Disciplina> {

    @Query("SELECT a FROM  Disciplina a WHERE a.nome =:nome")
    Optional<Disciplina> findByNome(String nome);

    /*@Query(value = "SELECT * FROM disciplinas INNER JOIN areas_conhecimento ON disciplinas.area_conhecimento = (SELECT id FROM areas_conhecimento WHERE nome = :nome)",  nativeQuery = true)
    Optional<Disciplina> findByAC(String area_conhecimento);*/

}
