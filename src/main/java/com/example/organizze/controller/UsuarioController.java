package com.example.organizze.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.organizze.model.Usuario;
import com.example.organizze.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Buscando todos usuarios
    @GetMapping("/all") //Endereco
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    //Buscando usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return usuarioRepository
                .findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuario não encontrado"));
      
    }

    //Salvando novo usuario
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save( @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Deletando usuario rest api
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Integer id){
        usuarioRepository.findById(id)
            .map(usuario -> {
                usuarioRepository.delete(usuario);
                return usuario;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Usuario não encontrado") );
       
	}

   //Alterando um usuario
   @PutMapping("/update/{id}")
   public  ResponseEntity update(@PathVariable Integer id, @RequestBody  Usuario usuario) {
      return usuarioRepository
               .findById(id)
               .map( usuarioExistente -> {
                   usuario.setId(usuarioExistente.getId());
                   usuarioRepository.save(usuario);
                   return ResponseEntity.noContent().build();
               }).orElseGet( () -> ResponseEntity.notFound().build() );

   }



    @GetMapping("/procurar")
    public List<Usuario> find( Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withStringMatcher(
                            ExampleMatcher.StringMatcher.CONTAINING
                        );

        Example example = Example.of(filtro, matcher);
        
        return usuarioRepository.findAll(example);

    }


}   