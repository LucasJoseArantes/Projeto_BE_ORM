package com.example.lead_manager.model;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Source")
@Data
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

}
