package com.example.swagger.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idNf;
    private int idItem;
    private int codProd;
    private BigDecimal valorUnit;
    private int quantidade;
    private BigDecimal desconto;

    // Getters e Setters
}
