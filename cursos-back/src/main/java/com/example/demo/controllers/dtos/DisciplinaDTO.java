package com.example.demo.controllers.dtos;

import com.example.demo.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DisciplinaDTO {

    private Long id;
    private String nome;
    private String cargaHoraria;
    private Boolean optativa;
    private Long areaConhecimento;

    public DisciplinaDTO (Disciplina disciplina) {

        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.cargaHoraria = disciplina.getCargaHoraria();
        this.optativa = disciplina.getOptativa();
        this.areaConhecimento = disciplina.getAreaConhecimento();
    }
}
