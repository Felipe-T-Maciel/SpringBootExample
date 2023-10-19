package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_seguradora")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Long cpnj;
    private String nome;
    @OneToOne
    private Endereco endereco;
    @ManyToMany
    private Set<Cliente> clientes;
}
