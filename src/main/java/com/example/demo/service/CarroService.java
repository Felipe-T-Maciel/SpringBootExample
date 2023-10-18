package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarroService {
    CarroRepository carroRepository;


    public Carro buscarCarro(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

    public void deletar(Integer id){
        carroRepository.deleteById(id);
    }

    public void salvar(Carro carro){
        carroRepository.save(carro);
    }

}
