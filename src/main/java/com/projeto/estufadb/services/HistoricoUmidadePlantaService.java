package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.HistoricoUmidadePlantaRepository;
import com.projeto.estufadb.repositories.PlantaRepository;
import com.projeto.estufadb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoUmidadePlantaService {

    @Autowired
    private HistoricoUmidadePlantaRepository historicoUmidadePlantaRepository;

    @Autowired
    private PlantaRepository plantaRepository;

    public HistoricoUmidadePlanta buscar(Long id) {
        Optional<HistoricoUmidadePlanta> historicoUmidadePlanta = historicoUmidadePlantaRepository.findById(id);

        return historicoUmidadePlanta.orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar o historico de umidade com ID " + id));
    }
}
