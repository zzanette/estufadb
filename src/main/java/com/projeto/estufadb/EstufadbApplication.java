package com.projeto.estufadb;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class EstufadbApplication implements CommandLineRunner {

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    public static void main(String[] args) {
        SpringApplication.run(EstufadbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EspeciePlanta morango = new EspeciePlanta(null, "Morango", 60, 80);
        EspeciePlanta cactus = new EspeciePlanta(null, "Cactus", 20, 50);
        EspeciePlanta cogumelo = new EspeciePlanta(null, "Cogumelo", 80, 90);
        EspeciePlanta violeta = new EspeciePlanta(null, "Violeta", 40, 80);
        EspeciePlanta lavanda = new EspeciePlanta(null, "Lavanda", 20, 30);

        especiePlantaRepository.saveAll(Arrays.asList(morango, cactus, cogumelo, violeta, lavanda));
    }
}

