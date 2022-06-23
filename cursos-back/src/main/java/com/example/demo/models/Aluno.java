package com.example.demo.models;

import com.example.demo.controllers.forms.AlunoForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "alunos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "matricula")
    private Long matricula;

    @Column (name = "nome")
    private String nome;

    @Column (name = "rg")
    private String rg;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "email")
    private String email;

    @Column (name = "observacoes")
    private String observacoes;

    public Aluno (AlunoForm form) {
        this.nome = form.getNome ();
        this.rg = form.getRg ();
        this.cpf = form.getCpf ();
        this.email = form.getEmail ();
        this.observacoes = form.getObservacoes ();
    }

    public void update (AlunoForm form) {
        this.nome = form.getNome ();
        this.rg = form.getRg ();
        this.cpf = form.getCpf ();
        this.email = form.getEmail ();
        this.observacoes = form.getObservacoes ();
    }

}
