package com.example.demo.controllers.dtos;

import com.example.demo.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfessorDTO {

    private Long matricula;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private Boolean coordenador;
    private Long areaConhecimento;

    public ProfessorDTO (Professor professor) {
        this.matricula = professor.getMatricula();
        this.nome = professor.getNome();
        this.rg = professor.getRg();
        this.cpf = professor.getCpf();
        this.email = professor.getEmail();
        this.coordenador = professor.getCoordenador();
        this.areaConhecimento = professor.getAreaConhecimento();
    }

}
