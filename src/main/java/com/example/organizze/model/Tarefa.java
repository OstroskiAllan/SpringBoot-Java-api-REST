package com.example.organizze.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Tarefa {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false, length = 200)
    private String observacaoTarefa;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @ManyToOne
    @JoinColumn(name = "tabela_id")
    private Tabela tabela;


}
