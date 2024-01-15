package com.example.organizze.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.organizze.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>  {

    List<Tarefa> findByTabelaId(Integer id);
}

