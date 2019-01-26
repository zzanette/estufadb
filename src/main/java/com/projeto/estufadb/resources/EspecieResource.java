package com.projeto.estufadb.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/especies")
public class EspecieResource {

    @RequestMapping(method = RequestMethod.GET)
    public String listar() {
        return "lista";
    }
}
