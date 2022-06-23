package com.example.demo.controllers.dtos;

import com.example.demo.models.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
public class AlunoDTO {

    private Long matricula;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String observacoes;

    public AlunoDTO (Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.rg = aluno.getRg();
        this.cpf = aluno.getCpf();
        this.email = aluno.getEmail();
        this.observacoes = aluno.getObservacoes();
    }

}
