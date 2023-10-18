package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepostitory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    public UsuarioRepostitory usuarioRepostitory;

    public void salvar(Usuario usuario){
        usuarioRepostitory.save(usuario);
    }

    public void deletar(Integer id){
        usuarioRepostitory.deleteById(id);
    }

    public Usuario buscarUm(Integer id){
        return usuarioRepostitory.findById(id).get();
    }

    public Collection<Usuario> buscarTodos(){
        return usuarioRepostitory.findAll();
    }
}
