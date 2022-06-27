package com.example.demo.services;

import com.example.demo.controllers.dtos.CoordenadorDTO;
import com.example.demo.models.Coordenador;
import com.example.demo.repositorys.CoordenadorRepository;
import com.example.demo.repositorys.specifications.CoordenadorSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CoordenadoresService {

    private final CoordenadorRepository repository;

    public CoordenadorDTO findById(Long id) {
        Coordenador c = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CoordenadorDTO(c);
    }

    public Page<Coordenador> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<Coordenador> findAll(Pageable pageable, String query) {
        return this.repository.findAll(CoordenadorSpecifications.likeGenericQuery(query), pageable);
    }

}
