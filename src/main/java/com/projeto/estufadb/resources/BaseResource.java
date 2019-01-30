package com.projeto.estufadb.resources;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public abstract class BaseResource {
    protected URI getUriExpanded(String path, Object... objects) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path).buildAndExpand(objects).toUri();
    }
}
