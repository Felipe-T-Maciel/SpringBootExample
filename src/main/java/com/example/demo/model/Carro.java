package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor

public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Carro(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.marca = rs.getString("marca");
        this.modelo = rs.getString("modelo");
        this.ano = rs.getInt("ano");
        this.preco = rs.getDouble("preco");
    }

    public Carro(int id) {
        this.id = id;
    }
}
