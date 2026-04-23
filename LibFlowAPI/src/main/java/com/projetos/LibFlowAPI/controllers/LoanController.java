package com.projetos.LibFlowAPI.controllers;

import com.projetos.LibFlowAPI.dtos.LoanRequestDto;
import com.projetos.LibFlowAPI.dtos.LoanResponseDto;
import com.projetos.LibFlowAPI.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping
    public ResponseEntity<LoanResponseDto> insert(@RequestBody LoanRequestDto dto){
        LoanResponseDto loan = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(loan.getId())
                .toUri();
        return ResponseEntity.created(uri).body(loan);
    }

    @GetMapping
    public ResponseEntity<Page<LoanResponseDto>> findAll(Pageable pageable){
        Page<LoanResponseDto> loan = service.findAll(pageable);
        return ResponseEntity.ok().body(loan);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LoanResponseDto> findById(@PathVariable Long id){
        LoanResponseDto loan = service.findById(id);
        return ResponseEntity.ok().body(loan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
