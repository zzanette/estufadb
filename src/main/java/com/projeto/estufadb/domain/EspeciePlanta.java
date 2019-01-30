package com.projeto.estufadb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class EspeciePlanta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float umidadeMinima;
    private Float umidadeMaxima;

    @OneToMany(mappedBy = "especiePlanta")
    private List<Planta> plantas = new ArrayList<>();

    public EspeciePlanta() {}

    public EspeciePlanta(Long id, String nome, Float umidadeMinima, Float umidadeMaxima) {
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

    public Float getUmidadeMinima() {
        return umidadeMinima;
    }

    public void setUmidadeMinima(Float umidadeMinima) {
        this.umidadeMinima = umidadeMinima;
    }

    public Float getUmidadeMaxima() {
        return umidadeMaxima;
    }

    public void setUmidadeMaxima(Float umidadeMaxima) {
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
