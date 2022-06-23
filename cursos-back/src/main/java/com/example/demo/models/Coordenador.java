package com.example.demo.models;

import com.example.demo.controllers.forms.CoordenadorForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "coordenadores")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "area_conhecimento")
    private String areaConhecimento;

    @Column (name = "professor")
    private String professor;

}
