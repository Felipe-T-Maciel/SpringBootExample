package com.example.demo.controller;

import com.example.demo.model.Seguradora;
import com.example.demo.service.SeguradoraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")

public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @GetMapping()
    public Collection<Seguradora> buscarSeguroCarro(){
        return seguradoraService.buscarTodos();
    }

    @GetMapping("/buscarUm")
    public Seguradora buscarSeguroCarro(@RequestParam Integer id){
        return seguradoraService.buscarUm(id);
    }
}
