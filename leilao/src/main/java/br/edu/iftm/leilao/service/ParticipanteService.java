package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository repo;

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Participante busca(Long id) {
		return repo.findById(id).get();
	}

	public Participante atualiza(Long id, Participante participante) {
		participante.setId(id);
		return repo.save(participante);
	}

	public Participante salva(Participante participante) {
		return repo.save(participante);
	}

	public List<Participante> busca() {
		List<Participante> lista = new ArrayList<Participante>();
		repo.findAll().forEach(p -> lista.add(p));
		return lista;
	}

}
