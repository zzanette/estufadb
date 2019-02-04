package com.projeto.estufadb;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.repositories.EspeciePlantaRepository;
import com.projeto.estufadb.repositories.PlantaRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlantaRepositoryIntegrationTest {

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private EspeciePlantaRepository especiePlantaRepository;

    @Test
    public void whenFindByCodigoSensor_thenReturnPlanta() {

        EspeciePlanta especiePlanta = new EspeciePlanta(null, "Especie Teste", new Float(55.5), new Float(70.5));
        especiePlanta = especiePlantaRepository.save(especiePlanta);

        Planta planta = new Planta(null, "TST01", especiePlanta);
        plantaRepository.save(planta);

        Planta findPlanta = plantaRepository.findByCodigoSensor("TST01").get();

        assertThat(findPlanta.getCodigoSensor()).isEqualTo(planta.getCodigoSensor());
    }

    @Test
    public void whenFindByEspesciePlanta_thenReturnListPlanta() {
        EspeciePlanta especiePlanta = new EspeciePlanta(null, "Especie List Teste", new Float(45), new Float(60.5));
        especiePlanta = especiePlantaRepository.save(especiePlanta);

        Planta planta1 = new Planta(null, "TST01", especiePlanta);
        plantaRepository.save(planta1);

        Planta planta2 = new Planta(null, "TST02", especiePlanta);
        plantaRepository.save(planta2);

        List<Planta> findPlantas = plantaRepository.findByEspeciePlanta(especiePlanta);

        assertThat(findPlantas.size()).isEqualTo(2);
    }


}
