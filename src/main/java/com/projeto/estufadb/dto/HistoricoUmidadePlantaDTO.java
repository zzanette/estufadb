package com.projeto.estufadb.dto;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

public class HistoricoUmidadePlantaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Umidade do histórico não pode ser vazia.")
    @DecimalMin(value = "0.0", message = "Menor procentagem para umidade deve ser 0.")
    @DecimalMax(value = "100.00", message = "Maior procentagem para umidade deve ser 100.")
    private Float umidade;

    @NotNull(message = "Data do histórico não pode ser vazia.")
    private Calendar data;

    @NotNull(message = "Código sensor é obrigatório para o histórico de umidade de planta.")
    private String codigoSensor;

    public HistoricoUmidadePlantaDTO() {}

    public HistoricoUmidadePlantaDTO(HistoricoUmidadePlanta historicoUmidadePlanta) {
        this.id = historicoUmidadePlanta.getId();
        this.umidade = historicoUmidadePlanta.getUmidade();
        this.data = historicoUmidadePlanta.getData();
        this.codigoSensor = historicoUmidadePlanta.getPlanta().getCodigoSensor();
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

    public String getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(String codigoSensor) {
        this.codigoSensor = codigoSensor;
    }
}
