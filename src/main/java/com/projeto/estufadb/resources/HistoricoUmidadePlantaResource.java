package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.services.HistoricoUmidadePlantaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/historico-umidade-planta")
public class HistoricoUmidadePlantaResource {

    @Autowired
    private HistoricoUmidadePlantaService historicoUmidadePlantaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<HistoricoUmidadePlanta> getById(@PathVariable Long id) {
        HistoricoUmidadePlanta historicoUmidadePlanta = historicoUmidadePlantaService.findById(id);

        return ResponseEntity.ok().body(historicoUmidadePlanta);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody HistoricoUmidadePlanta newHistoricoUmidadePlanta) {
         HistoricoUmidadePlanta historicoUmidadePlanta = historicoUmidadePlantaService.insert(newHistoricoUmidadePlanta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(historicoUmidadePlanta.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody HistoricoUmidadePlanta updatedHistoricoUmidadePlanta, @PathVariable Long id) {
        updatedHistoricoUmidadePlanta.setId(id);
        historicoUmidadePlantaService.update(updatedHistoricoUmidadePlanta);

        return ResponseEntity.noContent().build();
    }
}
