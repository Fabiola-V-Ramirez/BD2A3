package com.example.demo.repositorys;

import com.example.demo.models.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long>, JpaSpecificationExecutor<Coordenador> {

    @Query("SELECT a FROM Coordenador a WHERE a.areaConhecimento =:areaConhecimento")
    Optional<Coordenador> findByAreaConhecimento(String areaConhecimento);

    @Query("SELECT a FROM Coordenador a WHERE a.professor =:professor")
    Optional<Coordenador> findByProfessor(String professor);

}
