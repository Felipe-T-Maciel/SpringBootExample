package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double preco;
    @OneToOne(mappedBy = "veiculo")
    private Seguro seguro;
}
