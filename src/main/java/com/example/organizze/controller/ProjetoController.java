package com.example.organizze.controller;

import com.example.organizze.model.Projeto;
import com.example.organizze.model.Tabela;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.organizze.repository.ProjetoRepository;
import com.example.organizze.repository.TabelaRepository;

@RestController
@RequestMapping("/projeto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetoController {
    private ProjetoRepository projetoRepository;
    private TabelaRepository tabelaRepository;
    
    @Autowired
    public ProjetoController(ProjetoRepository projetoRepository, TabelaRepository tabelaRepository) {
        this.projetoRepository = projetoRepository;
        this.tabelaRepository = tabelaRepository;
    }

    @GetMapping("/dash/{projeto}")
    public ResponseEntity<List<Tabela>> getAllTabelasByProjeto(@PathVariable Integer projeto) {
        // Buscar todas as tabelas relacionadas ao projeto
        List<Tabela> tabelas = tabelaRepository.findByProjetoId(projeto);
        return new ResponseEntity<>(tabelas, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }
    /*
     * public List<Projeto> getAllProjeto() {
     * return projetoRepository.findAll();
     * }
     */

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Integer id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        Projeto savedProjeto = projetoRepository.save(projeto);
        return new ResponseEntity<>(savedProjeto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Integer id, @RequestBody Projeto projeto) {
        if (!projetoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        projeto.setId(id);
        Projeto updatedProjeto = projetoRepository.save(projeto);

        return new ResponseEntity<>(updatedProjeto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjeto(@PathVariable Integer id) {
        if (!projetoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        projetoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}