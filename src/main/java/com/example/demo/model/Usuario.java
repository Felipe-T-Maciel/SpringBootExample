package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    private String senha;
    private Integer idade;
    @ManyToOne
    private Carro carro;

}
