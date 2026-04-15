package com.projetos.LibFlowAPI.repositories;

import com.projetos.LibFlowAPI.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
