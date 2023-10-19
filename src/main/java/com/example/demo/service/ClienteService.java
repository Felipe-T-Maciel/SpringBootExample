package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepostitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ClienteService {

    public ClienteRepostitory usuarioRepostitory;

    public void salvar(Cliente usuario){
        usuarioRepostitory.save(usuario);
    }

    public void deletar(Integer id){
        usuarioRepostitory.deleteById(id);
    }

    public Cliente buscarUm(Integer id){
        return usuarioRepostitory.findById(id).get();
    }

    public Collection<Cliente> buscarTodos(){
        return usuarioRepostitory.findAll();
    }
}
