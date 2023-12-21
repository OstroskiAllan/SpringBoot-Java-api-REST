package com.example.organizze.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tabela")
public class Tabela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 45)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "projeto", nullable = false)
    private Projeto projeto;

    //@OneToMany(mappedBy = "tabela", cascade = CascadeType.ALL)
    // private List<Tarefa> tarefas;
    
    public Tabela(){}

    public Tabela(String nome, String observacoes,  Projeto projeto){
        super();
        this.nome = nome;
        this.projeto = projeto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
/*
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    } */
}


