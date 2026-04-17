package com.projetos.LibFlowAPI.mappers;

import com.projetos.LibFlowAPI.dtos.BookRequestDto;
import com.projetos.LibFlowAPI.dtos.BookResponseDto;
import com.projetos.LibFlowAPI.entities.Book;

public class BookMapper {

    public static Book toEntity(BookRequestDto dto){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setCategory(dto.getCategory());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setAvailable(true);
        return book;
    }

    public static BookResponseDto toResponseDto(Book book){
        return new BookResponseDto(
                book.getAuthor(),
                book.isAvailable(),
                book.getCategory(),
                book.getId(),
                book.getIsbn(),
                book.getTitle()
        );
    }
}
