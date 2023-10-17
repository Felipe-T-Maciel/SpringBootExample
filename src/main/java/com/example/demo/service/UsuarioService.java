package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.CarroDAO;
import com.example.demo.repository.UsuarioDAO;

import java.util.NoSuchElementException;

public class UsuarioService {

    public UsuarioDAO usuarioDAO;
    public CarroDAO carroDAO;

    public UsuarioService(){

        this.carroDAO = new CarroDAO();
        this.usuarioDAO = new UsuarioDAO();

    }

    public void inserir(Usuario usuario){
        try {
            usuarioDAO.inserir(usuario);

        }catch (NoSuchElementException e){
            carroDAO.inserir(usuario.getCarro());

        }

    }
}
