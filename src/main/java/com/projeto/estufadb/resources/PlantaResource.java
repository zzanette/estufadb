package com.projeto.estufadb.resources;


import com.projeto.estufadb.domain.Planta;
import com.projeto.estufadb.services.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/plantas")
public class PlantaResource {

    @Autowired
    private PlantaService plantaService;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        Planta planta = plantaService.buscar(id);

        return ResponseEntity.ok().body(planta);
    }
}
