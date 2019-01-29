package com.projeto.estufadb;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import com.projeto.estufadb.repositories.HistoricoUmidadePlantaRepository;
import com.projeto.estufadb.repositories.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class EstufadbApplication implements CommandLineRunner {

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private HistoricoUmidadePlantaRepository historicoUmidadePlantaRepository;

    public static void main(String[] args) {
        SpringApplication.run(EstufadbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDatabase();
    }

    private void initDatabase() {
        List<EspeciePlanta> listaEspeciePlantaGerada = initDataBaseEspeciePlanta();
        initDataBasePlanta(listaEspeciePlantaGerada);
    }

    private void initDataBasePlanta(List<EspeciePlanta> listaEspeciePlantaGerada) {
        listaEspeciePlantaGerada.forEach(especiePlanta -> {
            String codigoSensor = "";
            switch (especiePlanta.getNome()) {
                case "Morango":
                    codigoSensor = "MRO";
                    break;
                case "Cactus":
                    codigoSensor = "CAC";
                    break;
                case "Cogumelo":
                    codigoSensor = "COGU";
                    break;
                case "Violeta":
                    codigoSensor = "VIO";
                    break;
                case "Lavanda":
                    codigoSensor = "LAV";
                    break;
            }
            for (int i = 1; i < 4; i++) {
                Planta planta = plantaRepository.save(new Planta(null, codigoSensor+i, especiePlanta));

                Random umidadeAtual = new Random();
                HistoricoUmidadePlanta historico = new HistoricoUmidadePlanta(null,
                        umidadeAtual.nextInt(95) + 5,
                        Calendar.getInstance(),
                        planta
                );
                historicoUmidadePlantaRepository.save(historico);
            }
        });
    }

    private List<EspeciePlanta> initDataBaseEspeciePlanta() {
        EspeciePlanta morango = new EspeciePlanta( null, "Morango", 60, 80);
        EspeciePlanta cactus = new EspeciePlanta(  null, "Cactus", 20, 50);
        EspeciePlanta cogumelo = new EspeciePlanta(null, "Cogumelo", 80, 90);
        EspeciePlanta violeta = new EspeciePlanta(null, "Violeta", 40, 80);
        EspeciePlanta lavanda = new EspeciePlanta(null, "Lavanda", 20, 30);

        List<EspeciePlanta> lista = Arrays.asList(morango, cactus, cogumelo, violeta, lavanda);
        especiePlantaRepository.saveAll(lista);

        return lista;
    }
}

