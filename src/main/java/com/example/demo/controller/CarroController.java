package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroDAO;
import com.example.demo.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")

public class CarroController {
    private final CarroService carroService = new CarroService();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id){
        return carroService.buscarCarro(id);
    }

    @GetMapping
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroService.inserir(carro);
    }

    @PutMapping("/{id}")
    public void atualizar(
            @PathVariable Integer id,
            @RequestBody Carro carro){
        carroService.atualizar(id, carro);
    }
}

