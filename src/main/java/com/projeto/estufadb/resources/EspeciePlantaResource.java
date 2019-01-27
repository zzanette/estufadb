package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.services.EspeciePlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/especies-planta")
public class EspeciePlantaResource {

    @Autowired
    private EspeciePlantaService especiePlantaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        EspeciePlanta especiePlanta = especiePlantaService.buscar(id);

        return ResponseEntity.ok().body(especiePlanta);
    }
}
