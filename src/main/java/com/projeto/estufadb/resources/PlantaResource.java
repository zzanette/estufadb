package com.projeto.estufadb.resources;


import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.dto.PlantaDTO;
import com.projeto.estufadb.services.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/plantas")
public class PlantaResource extends BaseResource {

    @Autowired
    private PlantaService plantaService;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Planta> find(@PathVariable Long id) {
        Planta planta = plantaService.findById(id);
        return ResponseEntity.ok().body(planta);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Planta> findByCondigoSensor(
            @PathParam(value = "codigoSensor") String codigoSensor
    ) {
        Planta planta = plantaService.findByCodigoSensor(codigoSensor);
        return ResponseEntity.ok().body(planta);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Planta newPlanta) {
        Planta planta = plantaService.insert(newPlanta);
        return ResponseEntity.created(getUriExpanded("/{id}", planta.getId())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Planta updatePlanta, @PathVariable Long id) {
        updatePlanta.setId(id);
        plantaService.update(updatePlanta);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        plantaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/especie/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PlantaDTO>> getByEspecieId(@PathVariable Long id) {
        List<Planta> plantas = plantaService.getByEspecieId(id);
        List<PlantaDTO> plantaDTOS = plantas.stream().map(planta -> new PlantaDTO(planta)).collect(Collectors.toList());

        return ResponseEntity.ok().body(plantaDTOS);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<List<PlantaDTO>> page(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "desc") String direction
    ) {

        Page<Planta> plantas = plantaService.findPage(page, linesPerPage, direction, orderBy);
        Page<PlantaDTO> listaDTO = plantas.map(planta -> new PlantaDTO(planta));

        return ResponseEntity.ok().body(listaDTO.getContent());
    }
}
