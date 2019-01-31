package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.dto.HistoricoUmidadePlantaDTO;
import com.projeto.estufadb.repositories.HistoricoUmidadePlantaRepository;
import com.projeto.estufadb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoricoUmidadePlantaService {

    @Autowired
    private HistoricoUmidadePlantaRepository historicoUmidadePlantaRepository;

    @Autowired
    private PlantaService plantaService;

    public HistoricoUmidadePlanta findById(Long id) {
        Optional<HistoricoUmidadePlanta> historicoUmidadePlanta = historicoUmidadePlantaRepository.findById(id);
        return historicoUmidadePlanta.orElseThrow(() ->
                new ObjectNotFoundException("Não foi possivel encontrar o historico de umidade com ID " + id)
        );
    }

    public HistoricoUmidadePlanta insert(HistoricoUmidadePlantaDTO newHistoricoUmidadePlantaDTO) {
        newHistoricoUmidadePlantaDTO.setId(null);
        return historicoUmidadePlantaRepository.save(fromDTO(newHistoricoUmidadePlantaDTO));
    }

    public HistoricoUmidadePlanta update(HistoricoUmidadePlantaDTO updatedHistoricoUmidadePlantaDTO) {
        HistoricoUmidadePlanta historicoUmidadePlanta = findById(updatedHistoricoUmidadePlantaDTO.getId());
        updateDataHistoricoUmidadePlanta(historicoUmidadePlanta, updatedHistoricoUmidadePlantaDTO);

        return historicoUmidadePlantaRepository.save(historicoUmidadePlanta);
    }

    private void updateDataHistoricoUmidadePlanta(HistoricoUmidadePlanta historicoUmidadePlanta, HistoricoUmidadePlantaDTO updatedHistoricoUmidadePlantaDTO) {
        if (updatedHistoricoUmidadePlantaDTO.getData() != null) {
            historicoUmidadePlanta.setData(updatedHistoricoUmidadePlantaDTO.getData());
        }

        if (updatedHistoricoUmidadePlantaDTO.getUmidade() != null) {
            historicoUmidadePlanta.setUmidade(updatedHistoricoUmidadePlantaDTO.getUmidade());
        }
    }

    public void deleteById(Long id) {
        findById(id);
        historicoUmidadePlantaRepository.deleteById(id);
    }

    public Page<HistoricoUmidadePlanta> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        return historicoUmidadePlantaRepository.findAll(pageRequest);
    }

    public HistoricoUmidadePlanta fromDTO(HistoricoUmidadePlantaDTO historicoUmidadePlantaDTO) {
        HistoricoUmidadePlanta historicoUmidadePlanta = new HistoricoUmidadePlanta();
        Planta planta = plantaService.findByCodigoSensor(historicoUmidadePlantaDTO.getCodigoSensor());

        historicoUmidadePlanta.setId(historicoUmidadePlantaDTO.getId());
        historicoUmidadePlanta.setData(historicoUmidadePlantaDTO.getData());
        historicoUmidadePlanta.setUmidade(historicoUmidadePlantaDTO.getUmidade());
        historicoUmidadePlanta.setPlanta(planta);

        return historicoUmidadePlanta;
    }
}
