package com.projetos.LibFlowAPI.dtos;

public class BookResponseDto {

    private Long id;
    private String isbn;
    private String tittle;
    private String author;
    private String category;
    private boolean avaliable;

    public BookResponseDto() {
    }

    public BookResponseDto(String author, boolean avaliable, String category, Long id, String isbn, String tittle) {
        this.author = author;
        this.avaliable = avaliable;
        this.category = category;
        this.id = id;
        this.isbn = isbn;
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public String getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTittle() {
        return tittle;
    }
}
