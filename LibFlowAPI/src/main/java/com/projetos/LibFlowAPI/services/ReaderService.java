package com.projetos.LibFlowAPI.services;

import com.projetos.LibFlowAPI.entities.Reader;
import com.projetos.LibFlowAPI.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository repository;

    public Reader insert(Reader reader){
        return repository.save(reader);
    }

    public List<Reader> findAll(){
        return repository.findAll();
    }

    public Reader findById(Long id){
        Optional<Reader> reader = repository.findById(id);
        return reader.get();
    }

    public void delete(Long id){

    }
}
