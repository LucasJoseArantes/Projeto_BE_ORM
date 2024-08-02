package br.edu.iftm.entregas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.entregas.model.Pacote;
import br.edu.iftm.entregas.model.Rastreamento;
import br.edu.iftm.entregas.model.Endereco;
import br.edu.iftm.entregas.repository.EnderecoRepository;
import br.edu.iftm.entregas.repository.PacoteRepository;
import br.edu.iftm.entregas.repository.RastreamentoRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class EntregasApplication implements CommandLineRunner {
    
    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntregasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        Endereco endereco = new Endereco(123, "Rua 1", "Bairro 1", "Cidade 1", "Minas Gerais", "12345-678");

        Pacote pacote = new Pacote(1, "João", endereco, "Em trânsito");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date parsedDate = dateFormat.parse("2021-10-10 10:00");
        Date dataHora = new Date(parsedDate.getTime());

        Rastreamento rastreamento = new Rastreamento(123, "202020", dataHora, "Em trânsito", "Rua 1", pacote);

        System.out.println("Pacotes: " + pacote);
        System.out.println("Rastreamentos: " + rastreamento); 
        System.out.println("Endereços: " + endereco);
    }
}
