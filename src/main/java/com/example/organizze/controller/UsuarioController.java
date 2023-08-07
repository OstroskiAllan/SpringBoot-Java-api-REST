package com.example.organizze.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.organizze.model.Usuario;
import com.example.organizze.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Buscando todos usuarios
    @GetMapping("/all") //Endereco
    @ResponseBody       //Anotation importante, pois ela diz que vai responder no corpo da mensagem. 
        public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    //Buscando usuario por id
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
           
        if(usuario.isPresent()){
            return ResponseEntity.ok( usuario.get());
        }   
        return ResponseEntity.notFound().build();
    }

    //Salvando novo usuario
    @PostMapping("/save")
    @ResponseBody
    public Usuario save( @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Deletando usuario rest api
	@DeleteMapping("/del/{id}")
    @ResponseBody
	public ResponseEntity delete (@PathVariable Integer id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
	}

    //Alterando um usuario
    @PutMapping("/update/{id}")
    @ResponseBody
    public  ResponseEntity update(@PathVariable Integer id, @RequestBody  Usuario usuario) {
       return usuarioRepository
                .findById(id)
                .map( usuarioExistente -> {
                    usuario.setId(usuarioExistente.getId());
                    usuario.setNome(usuarioExistente.getNome());
                    usuario.setEmail(usuarioExistente.getEmail());
                    usuario.setSenha(usuarioExistente.getSenha());
                    usuarioRepository.save(usuario);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );

    }

}