package com.example.organizze.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false, length = 200, name = "observacao_tarefa")
    private String observacaoTarefa;

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "dataEntrega")
    private Date dataEntrega;


    @ManyToOne
    @JoinColumn(nullable = false, name = "tabela_id")
    private Tabela tabela;

    public Tarefa(){}

    public Tarefa(String observacaoTarefa, Date data, Date dataEntrega, Tabela tabela){
        super();
        this.observacaoTarefa = observacaoTarefa;
        this.tabela = tabela;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacaoTarefa() {
        return observacaoTarefa;
    }

    public void setObservacaoTarefa(String observacaoTarefa) {
        this.observacaoTarefa = observacaoTarefa;
    }   

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }   

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }   

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

}
