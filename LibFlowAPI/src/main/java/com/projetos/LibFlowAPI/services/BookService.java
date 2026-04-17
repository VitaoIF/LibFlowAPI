package com.projetos.LibFlowAPI.services;

import com.projetos.LibFlowAPI.dtos.BookRequestDto;
import com.projetos.LibFlowAPI.dtos.BookResponseDto;
import com.projetos.LibFlowAPI.entities.Book;
import com.projetos.LibFlowAPI.mappers.BookMapper;
import com.projetos.LibFlowAPI.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public BookResponseDto insert(BookRequestDto dto){
        Book book = BookMapper.toEntity(dto);

        Book saved = bookRepository.save(book);

        return BookMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public List<BookResponseDto> findAll(){
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponseDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookResponseDto findById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return BookMapper.toResponseDto(book);
    }

    @Transactional(readOnly = true)
    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public BookResponseDto update(Long id, BookRequestDto dto){
        Book entity = bookRepository.getReferenceById(id);
        updateBook(entity, dto);
        Book updated = bookRepository.save(entity);
        return BookMapper.toResponseDto(updated);
    }

    private void updateBook(Book entity, BookRequestDto dto){
        entity.setAuthor(dto.getAuthor());
        entity.setAvailable(true);
        entity.setCategory(dto.getCategory());
        entity.setTitle(dto.getTitle());
    }

}
