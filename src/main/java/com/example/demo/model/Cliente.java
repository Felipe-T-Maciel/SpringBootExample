package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    private String senha;
    private Integer idade;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Carro> carros;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente")
    private Set<Seguro> seguros;

}
