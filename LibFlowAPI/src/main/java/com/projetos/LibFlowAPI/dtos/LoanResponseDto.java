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

    public LoanResponseDto(BookResponseDto book, Long id, LocalDate loanDate, ReaderResponseDto reader, LocalDate returnDate, LoanStatus status) {
        this.book = book;
        this.id = id;
        this.loanDate = loanDate;
        this.reader = reader;
        this.returnDate = returnDate;
        this.status = status;
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
