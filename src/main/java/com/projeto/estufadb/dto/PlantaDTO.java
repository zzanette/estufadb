package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.Planta;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Codigo do sensor da planta não pode ser vazio.")
    private String codigoSensor;

    public PlantaDTO () {}

    public PlantaDTO(Planta planta) {
        this.id = planta.getId();
        this.codigoSensor = planta.getCodigoSensor();
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
}
