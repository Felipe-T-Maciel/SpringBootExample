package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table( name = "carro" )
@NoArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Carro(int id) {
        this.id = id;
    }
}
