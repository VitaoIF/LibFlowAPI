package com.projetos.LibFlowAPI.controllers;

import com.projetos.LibFlowAPI.dtos.BookRequestDto;
import com.projetos.LibFlowAPI.dtos.BookResponseDto;
import com.projetos.LibFlowAPI.entities.Book;
import com.projetos.LibFlowAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> insert(@RequestBody BookRequestDto dto) {

        BookResponseDto response = bookService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<BookResponseDto>> findAll(Pageable pageable){
        Page<BookResponseDto> bookList = bookService.findAll(pageable);
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookResponseDto> findById(@PathVariable Long id){
        BookResponseDto bookId = bookService.findById(id);
        return ResponseEntity.ok().body(bookId);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable Long id, @RequestBody BookRequestDto dto){
        BookResponseDto responseDto = bookService.update(id, dto);
        return ResponseEntity.ok().body(responseDto);
    }
}
