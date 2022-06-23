package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "perfis_usuarios")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_usuario")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public PerfilUsuario() {
    }

    public PerfilUsuario(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
