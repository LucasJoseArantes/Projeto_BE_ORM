package br.edu.iftm.entregas.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private String codigo;
    private Date data;
    private String status;
    private String local;

    @ManyToOne
    private Pacote pacote;

    public Rastreamento(int id, String codigo, Date data, String status, String local, Pacote pacote) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.local = local;
        this.pacote = pacote;
    }
}
