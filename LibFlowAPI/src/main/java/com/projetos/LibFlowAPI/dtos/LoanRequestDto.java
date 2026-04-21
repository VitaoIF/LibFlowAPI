package com.projetos.LibFlowAPI.dtos;

import com.projetos.LibFlowAPI.entities.enums.LoanStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class LoanRequestDto {
    private LoanStatus status;
    private LocalDate loanDate;
    private LocalDate returnDate;

    private UUID readerId;
    private Long book;

    public LoanRequestDto() {
    }

    public LoanRequestDto(Long book, LocalDate loanDate, UUID readerId, LocalDate returnDate, LoanStatus status) {
        this.book = book;
        this.loanDate = loanDate;
        this.readerId = readerId;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public UUID getReaderId() {
        return readerId;
    }

    public void setReaderId(UUID readerId) {
        this.readerId = readerId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        LoanRequestDto that = (LoanRequestDto) o;
        return Objects.equals(readerId, that.readerId) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(readerId);
        result = 31 * result + Objects.hashCode(book);
        return result;
    }
}
