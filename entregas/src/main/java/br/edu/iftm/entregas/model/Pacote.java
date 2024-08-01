package br.edu.iftm.entregas.model;

import java.util.Date;
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
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String destinatario;
    private Endereco endereco;
    private String status;

    public Pacote(String id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
    }

    public String consultarInformacoes() {
        return "Pacote{" +
                "id='" + id + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", endereco=" + endereco +
                ", status='" + status + '\'' +
                '}';
    }
}
