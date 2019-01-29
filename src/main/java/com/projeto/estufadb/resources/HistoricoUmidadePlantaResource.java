package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.services.HistoricoUmidadePlantaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/historico-umidade-planta")
public class HistoricoUmidadePlantaResource {

    @Autowired
    private HistoricoUmidadePlantaService historicoUmidadePlantaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        HistoricoUmidadePlanta historicoUmidadePlanta = historicoUmidadePlantaService.buscar(id);

        return ResponseEntity.ok().body(historicoUmidadePlanta);
    }

    @PostMapping
    public ResponseEntity<?> newHistoricoUmidadePlanta(@RequestBody HistoricoUmidadePlanta historicoUmidadePlanta) {
        return ResponseEntity.ok().body(historicoUmidadePlantaService.salvar(historicoUmidadePlanta));
    }
}
