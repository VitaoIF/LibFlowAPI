package com.projetos.LibFlowAPI.services;

import com.projetos.LibFlowAPI.entities.Book;
import com.projetos.LibFlowAPI.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book insert(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public Book update(Long id, Book book){
        Book entity = bookRepository.getReferenceById(id);
        updateBook(entity, book);
        return bookRepository.save(entity);
    }

    private void updateBook(Book entity, Book book){
        entity.setAuthor(book.getAuthor());
        entity.setAvailable(book.isAvailable());
        entity.setCategory(book.getCategory());
        entity.setTitle(book.getTitle());
    }

}
