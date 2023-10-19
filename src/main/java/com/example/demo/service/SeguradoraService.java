package com.example.demo.service;

import com.example.demo.model.Seguradora;
import com.example.demo.repository.SeguradoraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class SeguradoraService {
    private SeguradoraRepository seguradoraRepository;

    public void salvar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    public void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }
    public Seguradora buscarUm(Integer id){
        return seguradoraRepository.findById(id).get();
    }
    public Collection<Seguradora> buscarTodos(){
        return seguradoraRepository.findAll();
    }
}
