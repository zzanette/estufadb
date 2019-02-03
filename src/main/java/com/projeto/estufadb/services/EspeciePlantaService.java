package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.dto.EspeciePlantaDTO;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import com.projeto.estufadb.services.exceptions.DataIntegrityException;
import com.projeto.estufadb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspeciePlantaService {

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    public EspeciePlanta findById(Long id) {
        Optional<EspeciePlanta> especiePlanta = especiePlantaRepository.findById(id);
        return especiePlanta.orElseThrow(() -> new ObjectNotFoundException("Especie  de planta com id: " + id + "não encontrada."));
    }

    public EspeciePlanta insert(EspeciePlanta newEspeciePlanta) {
        newEspeciePlanta.setId(null);
        return especiePlantaRepository.save(newEspeciePlanta);
    }

    public void deleteById(Long id) {
        findById(id);
        try {
            especiePlantaRepository.deleteById(id);
        } catch (DataIntegrityViolationException exception) {
            throw new DataIntegrityException("Erro ao deletar espécie, existem plantas associadas a este registro.", exception);
        }
    }

    public EspeciePlanta update(EspeciePlanta especiePlanta) {
        findById(especiePlanta.getId());
        return especiePlantaRepository.save(especiePlanta);
    }

    public EspeciePlanta fromDTO(EspeciePlantaDTO especiePlantaDTO) {
        return new EspeciePlanta(especiePlantaDTO.getId(), especiePlantaDTO.getNome(), especiePlantaDTO.getUmidadeMinima(), especiePlantaDTO.getUmidadeMaxima());
    }

    public Page<EspeciePlanta> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        return especiePlantaRepository.findAll(pageRequest);
    }


}
