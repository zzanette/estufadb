package com.projeto.estufadb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoSensor;

    @ManyToOne
    @JoinColumn(name = "ESPECIE_PLANTA_ID")
    private EspeciePlanta especiePlanta;

    public Planta() {}

    public Planta(Long id, String codigoSensor, EspeciePlanta especiePlanta) {
        this.id = id;
        this.codigoSensor = codigoSensor;
        this.especiePlanta = especiePlanta;
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

    public EspeciePlanta getEspeciePlanta() {
        return especiePlanta;
    }

    public void setEspeciePlanta(EspeciePlanta especiePlanta) {
        this.especiePlanta = especiePlanta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planta planta = (Planta) o;
        return id.equals(planta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
