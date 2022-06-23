package com.example.demo.controllers.dtos;

import com.example.demo.models.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@AllArgsConstructor
@Getter
public class CursoDTO {

    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private Double cargaHoraria;

    public CursoDTO (Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.preco = curso.getPreco();
        this.descricao = curso.getDescricao();
        this.cargaHoraria = curso.getCargaHoraria();
    }

}
