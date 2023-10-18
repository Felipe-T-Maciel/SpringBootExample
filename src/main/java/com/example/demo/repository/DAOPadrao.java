package com.example.demo.repository;

import com.example.demo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DAOPadrao<T, ID> implements ICRUD<T,ID> {

    protected Connection connection;
    private String tabela;

    public DAOPadrao(String tabela){
        this.tabela = tabela;
    }

    protected void conectar(){
        this.connection = Banco.conectar();
    }

    @Override
    public Set<T> buscarTodos() {
        conectar();
        Set<T> listaTodos = new HashSet<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from "+tabela+";")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                listaTodos.add(converter(rs));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return listaTodos;
    }


    public void deletar(Integer integer) {
        conectar();
        try (PreparedStatement statement = connection.prepareStatement("delete from "+tabela+" where id=?;")){
            statement.setInt(1,integer);
            statement.execute();
            connection.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public T buscarUm(Integer integer) {
        conectar();
        try (PreparedStatement statement = connection.prepareStatement("select * from "+tabela+" where id=?")){
            statement.setInt(1,integer);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return converter(rs);
            }
            throw new NoSuchElementException();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public abstract T converter(ResultSet rs) throws SQLException;

}
