package com.example.demo.controller;

import com.example.demo.model.Seguro;
import com.example.demo.service.SeguroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/seguro")
@AllArgsConstructor
public class SeguroController {
    private SeguroService seguroService;

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        seguroService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

    @GetMapping()
    public Collection<Seguro> buscarSeguroCarro(){
        return seguroService.buscarTodos();
    }

    @GetMapping("/buscarUm")
    public Seguro buscarSeguroCarro(@RequestParam Integer id){
        return seguroService.buscarUm(id);
    }
}
