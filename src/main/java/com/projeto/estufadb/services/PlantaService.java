package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.PlantaRepository;
import com.projeto.estufadb.services.exceptions.ObjectNotFoundException;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    public Planta findById(Long id) {
        Optional<Planta> planta = plantaRepository.findById(id);
        return planta.orElseThrow(() -> new ObjectNotFoundException("Planta com o id " + id + " não encontrada."));
    }

    public Planta findByCodigoSensor(String codigoSensor) {
        Optional<Planta> planta = plantaRepository.findByCodigoSensor(codigoSensor);
        return planta.orElseThrow(() -> new ObjectNotFoundException("Planta com o código de sensor " + codigoSensor + "não encontrada."));
    }

    public Planta insert(Planta newPlanta) {
        newPlanta.setId(null);
        return plantaRepository.save(newPlanta);
    }

    public Planta update(Planta updatePlanta) {
        findById(updatePlanta.getId());
        return plantaRepository.save(updatePlanta);
    }

    public void deleteById(Long id) {
        findById(id);
        plantaRepository.deleteById(id);
    }
}
