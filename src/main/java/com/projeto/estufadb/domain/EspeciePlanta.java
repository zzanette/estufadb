package com.projeto.estufadb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity

public class EspeciePlanta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer umidadeMinima;
    private Integer umidadeMaxima;


    public EspeciePlanta() {}

    public EspeciePlanta(Long id, String nome, Integer umidadeMinima, Integer umidadeMaxima) {
        this.id = id;
        this.nome = nome;
        this.umidadeMinima = umidadeMinima;
        this.umidadeMaxima = umidadeMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUmidadeMinima() {
        return umidadeMinima;
    }

    public void setUmidadeMinima(Integer umidadeMinima) {
        this.umidadeMinima = umidadeMinima;
    }

    public Integer getUmidadeMaxima() {
        return umidadeMaxima;
    }

    public void setUmidadeMaxima(Integer umidadeMaxima) {
        this.umidadeMaxima = umidadeMaxima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspeciePlanta that = (EspeciePlanta) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
