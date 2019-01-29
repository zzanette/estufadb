package com.projeto.estufadb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoUmidadePlantaRepository extends JpaRepository<com.projeto.estufadb.domain.HistoricoUmidadePlanta, Long> {
}
