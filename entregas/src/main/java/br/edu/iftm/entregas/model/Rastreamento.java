package br.edu.iftm.entregas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Rastreamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigoRastreio;
    private String dataHora;
    private String status;
    private String localizacao;

    public String getResumo() {
        return "Código de Rastreio: " + codigoRastreio + ", Data e Hora: " + dataHora + ", Status: " + status;
    }
}
