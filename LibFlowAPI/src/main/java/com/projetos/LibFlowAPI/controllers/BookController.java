package com.projetos.LibFlowAPI.controllers;

import com.projetos.LibFlowAPI.entities.Book;
import com.projetos.LibFlowAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Book> insert(@RequestBody Book book){
        book = bookService.insert(book);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(uri).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> bookList = bookService.findAll();
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book bookId = bookService.findById(id);
        return ResponseEntity.ok().body(bookId);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        book = bookService.update(id, book);
        return ResponseEntity.ok().body(book);
    }
}
