package com.supermarket_rag.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,  unique = true)
    private String nome;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private int estoque;


}
