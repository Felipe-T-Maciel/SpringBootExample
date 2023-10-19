package com.example.demo.service;

import com.example.demo.model.Seguro;
import com.example.demo.repository.SeguroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(Seguro seguro){
        seguroRepository.save(seguro);
    }

    public void deletar(Integer id){
        seguroRepository.deleteById(id);
    }
    public Seguro buscarUm(Integer id){
        return seguroRepository.findById(id).get();
    }
    public Collection<Seguro> buscarTodos(){
        return seguroRepository.findAll();
    }
}
