package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.Planta;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Codigo do sensor da planta não pode ser vazio.")
    private String codigoSensor;

    private Float umidadeMinimaEspecie;

    private Float umidadeMaximaEspecie;

    private Float umidadeAtualPlanta;

    public PlantaDTO () {}

    public PlantaDTO(Planta planta) {
        this.id = planta.getId();
        this.codigoSensor = planta.getCodigoSensor();
        this.umidadeMinimaEspecie = planta.getEspeciePlanta().getUmidadeMinima();
        this.umidadeMaximaEspecie = planta.getEspeciePlanta().getUmidadeMaxima();
        this.umidadeAtualPlanta = planta.getUltimaUmidadeRegistrada();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(String codigoSensor) {
        this.codigoSensor = codigoSensor;
    }

    public Float getUmidadeMinimaEspecie() {
        return umidadeMinimaEspecie;
    }

    public void setUmidadeMinimaEspecie(Float umidadeMinimaEspecie) {
        this.umidadeMinimaEspecie = umidadeMinimaEspecie;
    }

    public Float getUmidadeMaximaEspecie() {
        return umidadeMaximaEspecie;
    }

    public void setUmidadeMaximaEspecie(Float umidadeMaximaEspecie) {
        this.umidadeMaximaEspecie = umidadeMaximaEspecie;
    }

    public Float getUmidadeAtualPlanta() {
        return umidadeAtualPlanta;
    }

    public void setUmidadeAtualPlanta(Float umidadeAtualPlanta) {
        this.umidadeAtualPlanta = umidadeAtualPlanta;
    }
}
