package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_plano")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;
    private String nome;
    private String descricao;
    @ManyToOne
    private Seguradora seguradora;
    @OneToOne
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;
}
