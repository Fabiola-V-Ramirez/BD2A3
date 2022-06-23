package com.example.demo.security;

import com.example.demo.models.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {

    @Query("SELECT a FROM PerfilUsuario a WHERE a.id = :id")
    Optional<PerfilUsuario> findByEmail(Long id);

}
