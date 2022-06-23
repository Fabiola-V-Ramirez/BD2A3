package com.example.demo.controllers.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorForm {

    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private Boolean coordenador;
    private Long areaConhecimento;

}
