package com.projetos.LibFlowAPI.services;

import com.projetos.LibFlowAPI.dtos.LoanRequestDto;
import com.projetos.LibFlowAPI.dtos.LoanResponseDto;
import com.projetos.LibFlowAPI.entities.Book;
import com.projetos.LibFlowAPI.entities.Loan;
import com.projetos.LibFlowAPI.entities.Reader;
import com.projetos.LibFlowAPI.mappers.LoanMapper;
import com.projetos.LibFlowAPI.repositories.BookRepository;
import com.projetos.LibFlowAPI.repositories.LoanRepository;
import com.projetos.LibFlowAPI.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    public LoanResponseDto insert(LoanRequestDto dto){

        Reader reader = readerRepository.findById(dto.getReaderId())
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado"));

        Book book = bookRepository.findById(dto.getBook())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Loan loan = LoanMapper.toEntity(dto);

        loan.setBook(book);
        loan.setReader(reader);

        loan = loanRepository.save(loan);

        return LoanMapper.toResponseDto(loan);
    }
}
