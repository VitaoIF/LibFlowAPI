package com.projetos.LibFlowAPI.dtos;

import com.projetos.LibFlowAPI.entities.enums.LoanStatus;

import java.time.LocalDate;

public class LoanResponseDto {
    private Long id;
    private LoanStatus status;
    private LocalDate loanDate;
    private LocalDate returnDate;

    private ReaderResponseDto reader;
    private BookResponseDto book;

    public LoanResponseDto() {
    }

    public LoanResponseDto(Long id, LoanStatus status, LocalDate loanDate, LocalDate returnDate, ReaderResponseDto reader, BookResponseDto book) {
        this.id = id;
        this.status = status;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.book = book;
    }

    public BookResponseDto getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public ReaderResponseDto getReader() {
        return reader;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }
}
