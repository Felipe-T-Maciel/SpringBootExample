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
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id){
        return usuarioDAO.buscarUm(id);
    }

    @GetMapping
    public Collection<Usuario> buscarTodos(){
        return usuarioDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        usuarioDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping("/{id}")
    public void inserir(
            @PathVariable Integer id,
            @RequestBody Usuario usuario){
        usuarioDAO.atualizar(usuario,id);
    }
}

