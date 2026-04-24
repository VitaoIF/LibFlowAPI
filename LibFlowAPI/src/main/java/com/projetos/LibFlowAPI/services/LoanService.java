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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<LoanResponseDto> findAll(Pageable pageable){
        Page<Loan> loans = loanRepository.findAll(pageable);
        return loans.map(LoanMapper::toResponseDto);
    }

    public LoanResponseDto findById(Long id){
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        return LoanMapper.toResponseDto(loan);
    }

    public void delete (Long id){
        loanRepository.deleteById(id);
    }

    public LoanResponseDto update(Long id, LoanRequestDto loanRequestDto){
       Loan entity = loanRepository.getReferenceById(id);
       updateLoan(entity, loanRequestDto);
       Loan loanUdpated = loanRepository.save(entity);
       return LoanMapper.toResponseDto(loanUdpated);
    }

    private void updateLoan(Loan entity, LoanRequestDto dto){
        entity.setReturnDate(dto.getReturnDate());
    }
}
