package com.example.demo.controllers.forms;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DisciplinaForm {

    private Long id;
    private String nome;
    private String cargaHoraria;
    private Boolean optativa;
    private Long areaConhecimento;

}
