package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.services.HistoricoUmidadePlantaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/historico-umidade-planta")
public class HistoricoUmidadePlantaResource extends BaseResource {

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
        return ResponseEntity.created( getUriExpanded("/{id}", historicoUmidadePlanta.getId())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody HistoricoUmidadePlanta updatedHistoricoUmidadePlanta, @PathVariable Long id) {
        updatedHistoricoUmidadePlanta.setId(id);
        historicoUmidadePlantaService.update(updatedHistoricoUmidadePlanta);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HistoricoUmidadePlanta> deleteById(@PathVariable Long id) {
        historicoUmidadePlantaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
