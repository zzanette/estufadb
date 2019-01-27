package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.PlantaRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    public Planta buscar(Long id) {
        Optional<Planta> planta = plantaRepository.findById(id);

        return planta.orElse(null);
    }

}
