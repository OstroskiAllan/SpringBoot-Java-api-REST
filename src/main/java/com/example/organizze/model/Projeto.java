package com.example.organizze.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = true, length = 200)
    private String observacoes;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "data")
    private Date data;

    /*
    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "dataFinal")
    private Date dataFinal;
    */

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Tabela> tabelas;

    public Projeto(){}

    public Projeto(String nome, String observacoes){
        super();
        this.nome = nome;
        this.observacoes = observacoes;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }   

    /* 
    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }   
    */
}
