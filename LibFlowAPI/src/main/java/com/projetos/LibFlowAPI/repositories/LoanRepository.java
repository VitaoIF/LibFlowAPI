package com.projetos.LibFlowAPI.repositories;

import com.projetos.LibFlowAPI.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
