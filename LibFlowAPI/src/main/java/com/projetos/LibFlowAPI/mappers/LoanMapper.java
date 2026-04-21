package com.projetos.LibFlowAPI.mappers;

import com.projetos.LibFlowAPI.dtos.BookResponseDto;
import com.projetos.LibFlowAPI.dtos.LoanRequestDto;
import com.projetos.LibFlowAPI.dtos.LoanResponseDto;
import com.projetos.LibFlowAPI.dtos.ReaderResponseDto;
import com.projetos.LibFlowAPI.entities.Loan;

public class LoanMapper {

    public static Loan toEntity(LoanRequestDto dto){
        Loan loan = new Loan();
        loan.setLoanDate(dto.getLoanDate());
        loan.setStatus(dto.getStatus());
        loan.setReturnDate(dto.getReturnDate());
        return loan;
    }

    public static LoanResponseDto toResponseDto(Loan loan){
        return new LoanResponseDto(
                        new BookResponseDto(
                                loan.getBook().getAuthor(),
                                loan.getBook().isAvailable(),
                                loan.getBook().getCategory(),
                                loan.getBook().getId(),
                                loan.getBook().getIsbn(),
                                loan.getBook().getTitle()
                        ),
                loan.getId(),
                loan.getLoanDate(),
                new ReaderResponseDto(
                                loan.getReader().getEmail(),
                                loan.getReader().getId(),
                                loan.getReader().getLocalDate(),
                                loan.getReader().getName(),
                                loan.getReader().getPhone()
                        ),
                loan.getReturnDate(),
                loan.getStatus());
    }
}
