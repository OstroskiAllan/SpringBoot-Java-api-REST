package com.example.organizze.repository;
import com.example.organizze.model.Projeto;
import com.example.organizze.model.Tabela;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    List<Tabela> findByTabelas_ProjetoId(Integer id);
}
