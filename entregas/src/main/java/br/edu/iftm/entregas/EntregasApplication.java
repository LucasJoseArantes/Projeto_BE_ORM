package br.edu.iftm.entregas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entregas.EntregasApplication;

import br.edu.iftm.entregas.model.Pacote;
import br.edu.iftm.entregas.model.Rastreamento;
import br.edu.iftm.entregas.repository.EnderecoRepository;
import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.repository.LanceRepository;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@SpringBootApplication
public class EntregasApplication implements CommandLineRunner {
	@Autowired
	private PacoteRepository pacote;

	@Autowired
	private RastreamentoRepository rastreamento;

	@Autowired
	private EnderecoRepository endereco;

	public static void main(String[] args) {
		SpringApplication.run(EntregasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pacote pacote = new Pacote(1 , "João", "Rua 1", "Em trânsito");
		Rastreamento rastreamento = new Rastreamento(123, "202020", "2021-10-10 10:00", "Em trânsito", "Rua 1");
		Endereco endereco = new Endereco(123, "Rua 1", "Bairro 1", "Cidade 1", "Minas Gerais", "12345-678");

		pacote.save(pacote);
		rastreamento.save(rastreamento);
		endereco.save(endereco);

		System.out.println("Pacote: " + pacote.findAll());
		System.out.println("Rastreamento: " + rastreamento.findAll());
		System.out.println("Endereco: " + endereco.findAll());
	
	}

}
