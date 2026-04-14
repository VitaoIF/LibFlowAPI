package com.projetos.LibFlowAPI.controllers;

import com.projetos.LibFlowAPI.entities.Reader;
import com.projetos.LibFlowAPI.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/readers")
public class ReaderController {

    @Autowired
    private ReaderService service;

    @PostMapping
    public ResponseEntity<Reader> insert(@RequestBody Reader reader){
        reader = service.insert(reader);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reader.getId())
                .toUri();
        return ResponseEntity.created(uri).body(reader);
    }

    @GetMapping
    public ResponseEntity<List<Reader>> findAll(){
        List<Reader> readers = service.findAll();
        return ResponseEntity.ok().body(readers);
    }

    @PutMapping
    public ResponseEntity<Reader> nothingForNow(){
        return null;
    }

}
