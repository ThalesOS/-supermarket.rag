package com.supermarket_rag.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Table(name = "itensPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;
    private Integer quantidade;
    private BigDecimal precoUnitario;

}
