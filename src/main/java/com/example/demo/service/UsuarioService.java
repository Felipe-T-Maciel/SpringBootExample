package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.CarroDAO;
import com.example.demo.repository.UsuarioDAO;

import java.util.Collection;
import java.util.NoSuchElementException;

public class UsuarioService {

    public UsuarioDAO usuarioDAO;
    public CarroService carroService;

    public UsuarioService(){

        this.carroService = new CarroService();
        this.usuarioDAO = new UsuarioDAO();

    }

    public void inserir(Usuario usuario){
        try {
            usuarioDAO.inserir(usuario);

        }catch (NoSuchElementException e){
            carroService.inserir(usuario.getCarro());

        }

    }

    public void atualizar(Usuario usuario, Integer id){
        try {
            carroService.buscarCarro(usuario.getCarro().getId());

        }catch (NoSuchElementException e){
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.atualizar(usuario, id);
    }

    public void deletar(Integer id){
        usuarioDAO.deletar(id);
    }

    public Usuario buscarUm(Integer id){
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(carroService.buscarCarro(usuario.getCarro().getId()));
        }catch (Exception ignore){}
        return usuario;
    }

    public Collection<Usuario> buscarTodos(){
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for (Usuario user:
             usuarios) {
            try {
                user.setCarro(carroService.buscarCarro(user.getCarro().getId()));
            }catch (Exception ignore){}
        }
        return usuarios;
    }
}
