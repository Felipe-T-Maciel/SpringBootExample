package com.example.demo.repository;

import com.example.demo.model.Carro;
import com.example.demo.repository.DAOPadrao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO extends DAOPadrao<Carro, Integer> {

    public CarroDAO(){
        super("carro");
    }

    @Override
    public Carro converter(ResultSet rs) throws SQLException {
        return new Carro(rs);
    }

    @Override
    public void inserir(Carro car) {
        String comandoSql = "insert into carro values(?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setInt(1,car.getId());
            statement.setString(2,car.getMarca());
            statement.setString(3,car.getModelo());
            statement.setInt(4,car.getAno());
            statement.setDouble(5,car.getPreco());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void atualizar(Carro car, Integer id) {
        String comandoSql = "update carro set marca = ?,modelo = ?, ano = ?, preco = ? where id= ?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setString(1,car.getMarca());
            statement.setString(2,car.getModelo());
            statement.setInt(3,car.getAno());
            statement.setDouble(4,car.getPreco());
            statement.setDouble(5,id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
