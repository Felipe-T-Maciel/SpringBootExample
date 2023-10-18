package com.example.demo.repository;

import com.example.demo.model.Usuario;
import com.example.demo.repository.DAOPadrao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAOPadrao<Usuario, Integer> {


    public UsuarioDAO(){
        super("usuario");
    }

    @Override
    public Usuario converter(ResultSet rs) throws SQLException {
        return new Usuario(rs);
    }

    @Override
    public void inserir(Usuario user) {
        conectar();
        String comandoSql = "insert into usuario values(?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setInt(1,user.getId());
            statement.setString(2,user.getNome());
            statement.setString(3,user.getSenha());
            statement.setInt(4,user.getIdade());
            statement.setInt(5,user.getCarro().getId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


    @Override
    public void atualizar(Usuario obj, Integer id) {
        conectar();
        String comandoSql = "update usuario set nome = ?,senha=?,idade = ?, id_carro = ? where id= ?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setString(1,obj.getNome());
            statement.setString(2,obj.getSenha());
            statement.setInt(3,obj.getIdade());
            statement.setInt(5,id);
            try {
                statement.setInt(4,obj.getCarro().getId());
            }catch (NullPointerException e){
                statement.setInt(4,0);
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                this.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
