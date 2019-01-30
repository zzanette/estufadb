package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;

import java.io.Serializable;
import java.util.Calendar;

public class HistoricoUmidadePlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer umidade;
    private Calendar data;

    public HistoricoUmidadePlantaDTO() {}

    public HistoricoUmidadePlantaDTO(HistoricoUmidadePlanta historicoUmidadePlanta) {
        this.id = historicoUmidadePlanta.getId();
        this.umidade = historicoUmidadePlanta.getUmidade();
        this.data = historicoUmidadePlanta.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUmidade() {
        return umidade;
    }

    public void setUmidade(Integer umidade) {
        this.umidade = umidade;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
