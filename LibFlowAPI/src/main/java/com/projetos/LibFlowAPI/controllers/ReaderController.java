package com.projetos.LibFlowAPI.controllers;

import com.projetos.LibFlowAPI.dtos.ReaderRequestDto;
import com.projetos.LibFlowAPI.dtos.ReaderResponseDto;
import com.projetos.LibFlowAPI.entities.Reader;
import com.projetos.LibFlowAPI.services.ReaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/readers")
public class ReaderController {

    @Autowired
    private ReaderService service;

    @PostMapping
    public ResponseEntity<ReaderResponseDto> insert(@Valid @RequestBody ReaderRequestDto readerRequestDto){
        ReaderResponseDto reader = service.insert(readerRequestDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reader.getId())
                .toUri();
        return ResponseEntity.created(uri).body(reader);
    }

    @GetMapping
    public ResponseEntity<Page<ReaderResponseDto>> findAll(Pageable pageable){
        Page<ReaderResponseDto> readers = service.findAll(pageable);
        return ResponseEntity.ok().body(readers);
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<Reader>> orderByCreationDate(){
        List<Reader> readers = service.creationDate();
        return ResponseEntity.ok().body(readers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReaderResponseDto> findById(@PathVariable UUID id){
        ReaderResponseDto reader = service.findById(id);
        return ResponseEntity.ok().body(reader);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@RequestBody UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReaderResponseDto> update(@PathVariable UUID id, @RequestBody ReaderRequestDto reader){
        ReaderResponseDto responseDto = service.update(id, reader);
        return ResponseEntity.ok().body(responseDto);
    }

}
