package com.example.organizze.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(length = 200)
    private String observacoes;

    @OneToMany(mappedBy = "tabela", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;
}
