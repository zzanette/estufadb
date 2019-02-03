package com.projeto.estufadb.resources;

import com.projeto.estufadb.domain.EspeciePlanta;
import com.projeto.estufadb.domain.HistoricoUmidadePlanta;
import com.projeto.estufadb.dto.EspeciePlantaDTO;
import com.projeto.estufadb.dto.HistoricoUmidadePlantaDTO;
import com.projeto.estufadb.services.EspeciePlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/especies-planta")
public class EspeciePlantaResource extends BaseResource {

    @Autowired
    private EspeciePlantaService especiePlantaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EspeciePlantaDTO> find(@PathVariable Long id) {
        EspeciePlanta especiePlanta = especiePlantaService.findById(id);

        return ResponseEntity.ok().body(new EspeciePlantaDTO(especiePlanta));
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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<EspeciePlantaDTO>> page(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {

        Page<EspeciePlanta> listaEspeciePlanta = especiePlantaService.findPage(page, linesPerPage, direction, orderBy);
        Page<EspeciePlantaDTO> listaDTO = listaEspeciePlanta.map(especiePlanta -> new EspeciePlantaDTO(especiePlanta));

        return ResponseEntity.ok().body(listaDTO);
    }
}
