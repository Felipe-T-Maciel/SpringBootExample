package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CarroService {

    public CarroRepository carroRepository;

    public void salvar(Carro carro){
        carroRepository.save(carro);
    }

    public void deletar(Integer id){
        carroRepository.deleteById(id);
    }

    public Carro buscarCarro(Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

}
