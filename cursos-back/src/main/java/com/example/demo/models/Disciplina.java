package com.example.demo.models;

import com.example.demo.controllers.forms.DisciplinaForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "carga_horaria")
    private String cargaHoraria;

    @Column (name = "optativa")
    private Boolean optativa;

    @Column (name = "area_conhecimento")
    private Long areaConhecimento;

    public Disciplina (DisciplinaForm form) {
        this.nome = form.getNome ();
        this.cargaHoraria = form.getCargaHoraria ();
        this.optativa = form.getOptativa ();
        this.areaConhecimento = form.getAreaConhecimento ();
    }

    public void update (DisciplinaForm form) {
        this.nome = form.getNome ();
        this.cargaHoraria = form.getCargaHoraria ();
        this.optativa = form.getOptativa ();
        this.areaConhecimento = form.getAreaConhecimento ();
    }

}
