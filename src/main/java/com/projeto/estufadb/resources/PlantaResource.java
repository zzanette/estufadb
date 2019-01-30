package com.projeto.estufadb.resources;


import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.services.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
