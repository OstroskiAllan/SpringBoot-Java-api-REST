package com.example.organizze.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.organizze.model.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, Integer>  {

    List<Tabela> findByProjetoId(Integer id);
}