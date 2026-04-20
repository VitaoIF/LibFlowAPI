package com.projetos.LibFlowAPI.repositories;

import com.projetos.LibFlowAPI.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReaderRepository extends JpaRepository<Reader, UUID> {
    List<Reader> findByOrderByLocalDateAsc();
}
