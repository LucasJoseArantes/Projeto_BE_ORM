package br.edu.iftm.entregas.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private int id;
    private String destinatario;

    @ManyToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "pacote")
    private List<Rastreamento> rastreamentos;

    private String status;

    public Pacote(int id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        // Adicionar lógica para criar um novo Rastreamento e associá-lo a este pacote, se necessário
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
