package com.projetos.LibFlowAPI.dtos;

import jakarta.persistence.Column;

public class BookRequestDto {
    @Column(nullable = false, unique = true)
    private String isbn;
    private String title;
    private String author;
    private String category;

    public BookRequestDto() {
    }

    public BookRequestDto(String author, String category, String isbn, String title) {
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
