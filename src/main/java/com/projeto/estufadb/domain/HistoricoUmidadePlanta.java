package com.projeto.estufadb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "HISTORICO_UMIDADE_PLANTA")
public class HistoricoUmidadePlanta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UMIDADE")
    private Float umidade;

    @Column(name = "DATA")
    private Calendar data;

    @ManyToOne
    @JoinColumn(name = "PLANTA_ID")
    private Planta planta;

    public HistoricoUmidadePlanta() {}

    public HistoricoUmidadePlanta(Long id, Float umidade, Calendar data, Planta planta) {
        this.id = id;
        this.umidade = umidade;
        this.data = data;
        this.planta = planta;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getUmidade() {
        return umidade;
    }

    public void setUmidade(Float umidade) {
        this.umidade = umidade;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoUmidadePlanta that = (HistoricoUmidadePlanta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
