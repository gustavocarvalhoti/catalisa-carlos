package com.biblioteca.bibliotecaSpring.repository;

import com.biblioteca.bibliotecaSpring.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivrosModel, Long> {
    //repositório = interface
}