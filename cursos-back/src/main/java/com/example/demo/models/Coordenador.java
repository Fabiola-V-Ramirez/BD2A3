package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coordenadores")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Coordenador {

    @Id
    @Column(name = "id")
    private Long id;

    @Column (name = "area_conhecimento")
    private String areaConhecimento;

    @Column (name = "professor")
    private String professor;

}
