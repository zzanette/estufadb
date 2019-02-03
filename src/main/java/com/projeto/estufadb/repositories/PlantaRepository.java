package com.projeto.estufadb.repositories;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.Planta;
import java.util.List;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

    @Transactional(readOnly = true)
    Optional<Planta> findByCodigoSensor(String codigoSensor);

    List<Planta> findByEspeciePlanta(EspeciePlanta especiePlanta);
}
