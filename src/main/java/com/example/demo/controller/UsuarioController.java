package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.Banco;
import com.example.demo.repository.UsuarioDAO;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();

//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService
//    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping
    public Collection<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping("/{id}")
    public void inserir(
            @PathVariable Integer id,
            @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario,id);
    }
}

