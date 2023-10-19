package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class ClienteController {

    private ClienteService usuarioService;

    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Cliente usuario){
        usuarioService.salvar(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Cliente usuario){
        usuarioService.salvar(usuario);
    }
}

