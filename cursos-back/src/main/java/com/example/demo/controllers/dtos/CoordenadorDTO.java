package com.example.demo.controllers.dtos;

import com.example.demo.models.Coordenador;
import lombok.Getter;

@Getter
public class CoordenadorDTO {

    private Long id;
    private String areaConhecimento;
    private String professor;

    public CoordenadorDTO (Coordenador coordenador) {
        this.id = coordenador.getId();
        this.areaConhecimento = coordenador.getAreaConhecimento();
        this.professor = coordenador.getProfessor();
    }

}
