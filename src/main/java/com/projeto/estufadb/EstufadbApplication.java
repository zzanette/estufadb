package com.projeto.estufadb;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import com.projeto.estufadb.repositories.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class EstufadbApplication implements CommandLineRunner {

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    @Autowired
    private PlantaRepository plantaRepository;

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

        Planta morango1 = new Planta(null, "MRO1", morango);
        Planta morango2 = new Planta(null, "MRO2", morango);
        Planta morango3 = new Planta(null, "MRO3", morango);
        plantaRepository.saveAll(Arrays.asList(morango1, morango2, morango3));

        Planta cactus1 = new Planta(null, "CAC1", cactus);
        Planta cactus2 = new Planta(null, "CAC2", cactus);
        Planta cactus3 = new Planta(null, "CAC3", cactus);
        plantaRepository.saveAll(Arrays.asList(cactus1, cactus2, cactus3));

        Planta cogumelo1 = new Planta(null, "COG1", cogumelo);
        Planta cogumelo2 = new Planta(null, "COG2", cogumelo);
        Planta cogumelo3 = new Planta(null, "COG3", cogumelo);
        plantaRepository.saveAll(Arrays.asList(cogumelo1, cogumelo2, cogumelo3));

        Planta violeta1 = new Planta(null, "VIO1", violeta);
        Planta violeta2 = new Planta(null, "VIO2", violeta);
        Planta violeta3 = new Planta(null, "VIO3", violeta);
        plantaRepository.saveAll(Arrays.asList(violeta1, violeta2, violeta3));

        Planta lavanda1 = new Planta(null, "LAV1", lavanda);
        Planta lavanda2 = new Planta(null, "LAV2", lavanda);
        Planta lavanda3 = new Planta(null, "LAV3", lavanda);
        plantaRepository.saveAll(Arrays.asList(lavanda1, lavanda2, lavanda3));
    }
}

