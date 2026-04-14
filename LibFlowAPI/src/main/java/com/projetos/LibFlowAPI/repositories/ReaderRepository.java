package com.projetos.LibFlowAPI.repositories;

import com.projetos.LibFlowAPI.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findByOrderByLocalDateAsc();
}
