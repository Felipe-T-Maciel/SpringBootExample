package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarroService {
    CarroDAO carroDAO;

    public CarroService(){
        this.carroDAO = new CarroDAO();
    }

    public Carro buscarCarro(Integer id){
        return carroDAO.buscarUm(id);
    }

    public Collection<Carro> buscarTodos(){
        return carroDAO.buscarTodos();
    }

    public void deletar(Integer id){
        carroDAO.deletar(id);
    }

    public void inserir(Carro carro){
        carroDAO.inserir(carro);
    }

    public void atualizar(
            Integer id,
            Carro carro){
        carroDAO.atualizar(carro,id);
    }
}
