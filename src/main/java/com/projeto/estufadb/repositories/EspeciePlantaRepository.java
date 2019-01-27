package com.projeto.estufadb.repositories;

import com.projeto.estufadb.domain.EspeciePlanta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspeciePlantaRepository extends JpaRepository<EspeciePlanta, Long> {
}
