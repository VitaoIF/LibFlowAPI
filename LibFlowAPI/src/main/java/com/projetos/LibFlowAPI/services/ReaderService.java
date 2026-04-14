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
        repository.deleteById(id);
    }

    public Reader update(Long id, Reader reader){
        Reader entity = repository.getReferenceById(id);
        updateReader(entity, reader);
        return repository.save(entity);
    }

    private void updateReader(Reader entity, Reader reader){
        entity.setName(reader.getName());
        entity.setEmail(reader.getEmail());
        entity.setPhone(reader.getPhone());
        entity.setPassword(reader.getPassword());
    }
}
