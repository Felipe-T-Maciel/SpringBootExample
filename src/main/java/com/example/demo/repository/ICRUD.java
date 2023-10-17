package com.example.demo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface ICRUD<T, ID> {
    void inserir(T obj);
    T buscarUm(ID id);
    Set<T> buscarTodos();
    void atualizar( T obj, ID id);
    void deletar(ID id);
}
