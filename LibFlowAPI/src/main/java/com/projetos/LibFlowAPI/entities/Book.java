package com.projetos.LibFlowAPI.entities;

import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean available;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, String category, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(isbn);
        return result;
    }
}
