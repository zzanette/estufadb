package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.EspeciePlanta;

import java.io.Serializable;

public class EspeciePlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Float umidadeMinima;
    private Float umidadeMaxima;

    public EspeciePlantaDTO() {}

    public EspeciePlantaDTO(EspeciePlanta especiePlanta) {
        this.id = especiePlanta.getId();
        this.nome = especiePlanta.getNome();
        this.umidadeMinima = especiePlanta.getUmidadeMinima();
        this.umidadeMinima = especiePlanta.getUmidadeMaxima();
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
}
