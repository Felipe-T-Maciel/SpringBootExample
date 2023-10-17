package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")

public class CarroController {
    private final CarroDAO carroDAO = new CarroDAO();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id){
        return carroDAO.buscarUm(id);
    }

    @GetMapping
    public Collection<Carro> buscarTodos(){
        return carroDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        carroDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroDAO.inserir(carro);
    }

    @PutMapping("/{id}")
    public void inserir(
            @PathVariable Integer id,
            @RequestBody Carro carro){
        carroDAO.atualizar(carro,id);
    }
}

