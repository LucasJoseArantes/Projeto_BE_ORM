package br.edu.iftm.entregas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String destinatario;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String status;

    public String getEnderecoCompleto() {
        return rua + ", " + numero + ", " + cidade + ", " + estado + ", " + cep;
    }

}
