package com.projetos.LibFlowAPI.entities;

import com.projetos.LibFlowAPI.entities.enums.LoanStatus;

import java.time.LocalDate;

public class Loan {

    private Long id;
    private LoanStatus status;

    private LocalDate loanDate;
    private LocalDate returnDate;
}
