package com.example.organizze.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.organizze.model.Tabela;
import com.example.organizze.model.Tarefa;
import com.example.organizze.repository.TabelaRepository;
import com.example.organizze.repository.TarefaRepository;

@RestController
@RequestMapping("/tabela")
@CrossOrigin(origins = "http://localhost:4200")
public class TabelaController {
    private TabelaRepository tabelaRepository;
    private TarefaRepository tarefaRepository;
    
    @Autowired
    public TabelaController(TabelaRepository tabelaRepository, TarefaRepository tarefaRepository) {
        this.tabelaRepository = tabelaRepository;
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping("/tt/{tabela}")
    public ResponseEntity<List<Tarefa>> getAllTarefasByTabela(@PathVariable Integer tabela) {
        // Buscar todas as tarefas relacionadas a tarefa
        List<Tarefa> tarefas = tarefaRepository.findByTabelaId(tabela);
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tabela> getTabelaById(@PathVariable Integer id) {
        Optional<Tabela> tabela = tabelaRepository.findById(id);
        return tabela.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tabela> createTabela(@RequestBody Tabela tabela) {
        Tabela savedTabela = tabelaRepository.save(tabela);
        return new ResponseEntity<>(savedTabela, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tabela> updateTabela(@PathVariable Integer id, @RequestBody Tabela tabela) {
        if (!tabelaRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tabela.setId(id);
        Tabela updatedTabela = tabelaRepository.save(tabela);

        return new ResponseEntity<>(updatedTabela, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabela(@PathVariable Integer id) {
        if (!tabelaRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tabelaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}   
