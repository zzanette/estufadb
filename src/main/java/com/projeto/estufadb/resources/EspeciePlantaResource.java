package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.dto.EspeciePlantaDTO;
import com.projeto.estufadb.services.EspeciePlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/especies-planta")
public class EspeciePlantaResource extends BaseResource {

    @Autowired
    private EspeciePlantaService especiePlantaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EspeciePlanta> find(@PathVariable Long id) {
        EspeciePlanta especiePlanta = especiePlantaService.findById(id);

        return ResponseEntity.ok().body(especiePlanta);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Valid @RequestBody EspeciePlantaDTO newEspeciePlantaDTO) {
        newEspeciePlantaDTO.setId(null);
        EspeciePlanta especiePlanta = especiePlantaService.insert(especiePlantaService.fromDTO(newEspeciePlantaDTO));

        return ResponseEntity.created(getUriExpanded("/{id}", especiePlanta.getId())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody EspeciePlantaDTO especiePlantaDTO, @PathVariable Long id) {
        especiePlantaDTO.setId(id);
        especiePlantaService.update(especiePlantaService.fromDTO(especiePlantaDTO));

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        especiePlantaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
