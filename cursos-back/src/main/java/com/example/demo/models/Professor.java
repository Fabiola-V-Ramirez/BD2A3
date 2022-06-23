package com.example.demo.models;

import com.example.demo.controllers.forms.ProfessorForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "professores")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor {

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

    @Column (name = "coordenador")
    private Boolean coordenador;

    @Column (name = "area_conhecimento")
    private Long areaConhecimento;

    public Professor (ProfessorForm form) {
        this.nome = form.getNome ();
        this.rg = form.getRg ();
        this.cpf = form.getCpf ();
        this.email = form.getEmail ();
        this.coordenador = form.getCoordenador();
        this.areaConhecimento = form.getAreaConhecimento ();
    }

    public void update (ProfessorForm form) {
        this.nome = form.getNome ();
        this.rg = form.getRg ();
        this.cpf = form.getCpf ();
        this.email = form.getEmail ();
        this.coordenador = form.getCoordenador();
        this.areaConhecimento = form.getAreaConhecimento ();
    }

}
