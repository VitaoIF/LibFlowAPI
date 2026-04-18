package com.projetos.LibFlowAPI.services;

import com.projetos.LibFlowAPI.dtos.ReaderRequestDto;
import com.projetos.LibFlowAPI.dtos.ReaderResponseDto;
import com.projetos.LibFlowAPI.entities.Reader;
import com.projetos.LibFlowAPI.mappers.ReaderMapper;
import com.projetos.LibFlowAPI.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository repository;

    public ReaderResponseDto insert(ReaderRequestDto readerRequestDto){
        Reader reader = ReaderMapper.toEntity(readerRequestDto);
        Reader saved = repository.save(reader);
        return ReaderMapper.toResponseDTO(saved);
    }

    public Page<ReaderResponseDto> findAll(Pageable pageable){
        Page<Reader> readers = repository.findAll(pageable);
        return readers.map(ReaderMapper::toResponseDTO);
    }

    public ReaderResponseDto findById(Long id){
        Reader reader = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encotrado"));
        return ReaderMapper.toResponseDTO(reader);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public ReaderResponseDto update(Long id, ReaderRequestDto readerRequestDto){
        Reader entity = repository.getReferenceById(id);
        updateReader(entity, readerRequestDto);
        Reader atualizado = repository.save(entity);
        return ReaderMapper.toResponseDTO(atualizado);
    }

    public List<Reader> creationDate(){
        return repository.findByOrderByLocalDateAsc();
    }

    private void updateReader(Reader entity, ReaderRequestDto reader){
        entity.setName(reader.getName());
        entity.setEmail(reader.getEmail());
        entity.setPhone(reader.getPhone());
        entity.setPassword(reader.getPassword());
    }
}
