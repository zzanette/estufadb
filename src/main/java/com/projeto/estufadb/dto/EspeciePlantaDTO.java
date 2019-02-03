package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.EspeciePlanta;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class EspeciePlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Nome da espécie não pode ser vazio.")
    @Length(min = 3, max = 100, message = "Nome da especie deve ser entre 3 e 100 caracteres.")
    private String nome;

    @NotNull(message = "Umidade minima não pode ser vazia.")
    @DecimalMin(value = "0.0", message = "Menor procentagem para umidade minima deve ser 0.")
    @DecimalMax(value = "100.00", message = "Maior procentagem para umidade minima deve ser 100.")
    private Float umidadeMinima;

    @NotNull(message = "Umidade máxima não pode ser vazia.")
    @DecimalMin(value = "0.0", message = "Menor procentagem para umidade minima deve ser 0.")
    @DecimalMax(value = "100.00", message = "Maior procentagem para umidade minima deve ser 100.")
    private Float umidadeMaxima;

    private String imgUrl;

    public EspeciePlantaDTO() {}

    public EspeciePlantaDTO(EspeciePlanta especiePlanta) {
        this.id = especiePlanta.getId();
        this.nome = especiePlanta.getNome();
        this.umidadeMinima = especiePlanta.getUmidadeMinima();
        this.umidadeMaxima = especiePlanta.getUmidadeMaxima();
        this.imgUrl = especiePlanta.getImgUrl();
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
