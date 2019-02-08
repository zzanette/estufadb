package com.projeto.estufadb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.*;
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

    @NotNull(message = "Nome da espécie não pdoe ser nulo.")
    @NotEmpty(message = "Nome da espécie não pode ser vazio.")
    @NotBlank(message = "Nome da espécie não pode conter.")
    private String nome;

    @NotNull(message = "Umidade Minima não pdoe ser nula.")
    @Min(value = 0, message = "Umidade Mínima deve estar entre 0% e 100%.")
    @Max(value = 100, message = "Umidade Mínima deve estar entre 0% e 100%.")
    private Float umidadeMinima;

    @NotNull(message = "Umidade Máxima não pdoe ser nula.")
    @Min(value = 0, message = "Umidade Mínima deve estar entre 0% e 100%.")
    @Max(value = 100, message = "Umidade Mínima deve estar entre 0% e 100%.")
    private Float umidadeMaxima;

    @Pattern(regexp = ".*\\.jpg|.*\\.jpeg|.*\\.gif|.*\\.png", message = "Arquivo deve estar nas extensões jpg, jpeg, gif ou png")
    private String imgUrl;

    @OneToMany(mappedBy = "especiePlanta")
    private List<Planta> plantas = new ArrayList<>();

    public EspeciePlanta() {}

    public EspeciePlanta(Long id, @Valid String nome, @Valid Float umidadeMinima, @Valid Float umidadeMaxima) {
        this.id = id;
        this.nome = nome;
        this.umidadeMinima = umidadeMinima;
        this.umidadeMaxima = umidadeMaxima;
        this.imgUrl = "https://www.zigg.com.br/static/img/no-imagem.png";
    }

    public EspeciePlanta(Long id, @Valid String nome, @Valid Float umidadeMinima, @Valid Float umidadeMaxima, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.umidadeMinima = umidadeMinima;
        this.umidadeMaxima = umidadeMaxima;
        this.imgUrl = imgUrl;
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

    public void setNome(@Valid String nome) {
        this.nome = nome;
    }

    public Float getUmidadeMinima() {
        return umidadeMinima;
    }

    public void setUmidadeMinima(@Valid Float umidadeMinima) {
        this.umidadeMinima = umidadeMinima;
    }

    public Float getUmidadeMaxima() {
        return umidadeMaxima;
    }

    public void setUmidadeMaxima(@Valid Float umidadeMaxima) {
        this.umidadeMaxima = umidadeMaxima;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(@Valid String imgUrl) {
        this.imgUrl = imgUrl;
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
