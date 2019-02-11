package com.projeto.estufadb.services;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import com.projeto.estufadb.repositories.HistoricoUmidadePlantaRepository;
import com.projeto.estufadb.repositories.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Service
public class DataBaseService {
    private static boolean isInitialized = false;

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private HistoricoUmidadePlantaRepository historicoUmidadePlantaRepository;

    public DataBaseService() {}

    public boolean initDatabase() {
        if (!isInitialized) {
            List<EspeciePlanta> listaEspeciePlantaGerada = initDataBaseEspeciePlanta();
            initDataBasePlanta(listaEspeciePlantaGerada);
            isInitialized = true;
        }

        return isInitialized;
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
                case "Rosa":
                    codigoSensor = "ROS";
                    break;
                case "Orquidea":
                    codigoSensor = "ORQ";
                    break;
            }
            for (int i = 1; i < 4; i++) {
                Planta planta = plantaRepository.save(new Planta(null, codigoSensor+i, especiePlanta));

                Random umidadeAtual = new Random();
                Random umidadeAtualDec = new Random();
                HistoricoUmidadePlanta historico = new HistoricoUmidadePlanta(null,
                        ((float) umidadeAtual.nextInt(95) + 5) + ((float) umidadeAtualDec.nextInt(99) / 100) ,
                        Calendar.getInstance(),
                        planta
                );
                historicoUmidadePlantaRepository.save(historico);
            }
        });
    }

    private List<EspeciePlanta> initDataBaseEspeciePlanta() {
        EspeciePlanta morango = new EspeciePlanta( null, "Morango", new Float("60.00"), new Float("80.00"));
        EspeciePlanta cactus = new EspeciePlanta(  null, "Cactus",   new Float("20.00"), new Float("50.00"));
        EspeciePlanta cogumelo = new EspeciePlanta(null, "Cogumelo", new Float("80.00"), new Float("90.00"));
        EspeciePlanta violeta = new EspeciePlanta(null, "Violeta",   new Float("40.00"), new Float("80.00"));
        EspeciePlanta lavanda = new EspeciePlanta(null, "Lavanda",   new Float("20.00"), new Float("30.00"));
        EspeciePlanta orquidea = new EspeciePlanta(null, "Orquidea",  new Float("30.00"), new Float("50.00"));
        EspeciePlanta rosa = new EspeciePlanta(null, "Rosa",   new Float("50.00"), new Float("70.00"));

        List<EspeciePlanta> lista = Arrays.asList(morango, cactus, cogumelo, violeta, lavanda, orquidea, rosa);
        especiePlantaRepository.saveAll(lista);

        return lista;
    }
}
