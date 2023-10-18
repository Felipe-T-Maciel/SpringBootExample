package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

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
        carroService.salvar(carro);
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro){
        carroService.salvar(carro);
    }
}

