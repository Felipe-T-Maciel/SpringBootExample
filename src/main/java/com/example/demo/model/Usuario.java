package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Consorcio consorcio;
}
