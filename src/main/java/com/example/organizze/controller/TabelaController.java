package com.example.organizze.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.organizze.model.Tabela;
import com.example.organizze.repository.TabelaRepository;

@RestController
@RequestMapping("/tabela")
@CrossOrigin(origins = "http://localhost:4200")
public class TabelaController {
    private TabelaRepository tabelaRepository;

    @Autowired
    public TabelaController(TabelaRepository tabelaRepository) {
        this.tabelaRepository = tabelaRepository;
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
