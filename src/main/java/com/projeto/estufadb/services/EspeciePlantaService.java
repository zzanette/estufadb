package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspeciePlantaService {

    @Autowired
    private EspeciePlantaRepository repository;

    public EspeciePlanta buscar(Long id) {
        Optional<EspeciePlanta> especiePlanta = repository.findById(id);

        return especiePlanta.orElse(null);
    }
}
