package com.example.demo.models;

import com.example.demo.controllers.forms.CursoForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "preco")
    private Double preco;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "carga_horaria")
    private Double cargaHoraria;

    public Curso (CursoForm form) {
        this.nome = form.getNome ();
        this.descricao = form.getDescricao ();
        this.preco = form.getPreco ();
        this.cargaHoraria = form.getCargaHoraria();
    }

    public void update (CursoForm form) {
        this.nome = form.getNome ();
        this.descricao = form.getDescricao ();
        this.preco = form.getPreco ();
        this.cargaHoraria = form.getCargaHoraria();
    }

}
