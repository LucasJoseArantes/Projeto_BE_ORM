package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemdeLeilaoService {

	@Autowired
	private ItemDeLeilaoRepository repo;

	@Autowired
	private LanceService lanceService;

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public ItemDeLeilao busca(Long id) {
		return repo.findById(id).get();
	}

	public ItemDeLeilao atualiza(Long id, ItemDeLeilao item) {
		ItemDeLeilao itemExistente = repo.findById(id).get();
		itemExistente.setNome(item.getNome());
		itemExistente.setValorMinimo(item.getValorMinimo());
		itemExistente.setLeilaoAberto(item.isLeilaoAberto());
		return repo.save(itemExistente);
	}

	public ItemDeLeilao salva(ItemDeLeilao item) {
		return repo.save(item);
	}

	public List<ItemDeLeilao> itens() {
		List<ItemDeLeilao> lista = new ArrayList<ItemDeLeilao>();
		repo.findAll().forEach(i -> lista.add(i));
		return lista;
	}

	public ItemDeLeilao registraLance(Lance lance, Long id) {
		ItemDeLeilao item = repo.findById(id).get();
		if (item.isLeilaoAberto()) {
			Lance lancePersistido = lanceService.salva(lance);
			item.getLancesRecebidos().add(lancePersistido);
			if (item.getLanceVencedor() == null || item.getLanceVencedor().getValor() < lance.getValor()) {
				item.setLanceVencedor(lancePersistido);
			}
		} else {
			throw new UnsupportedOperationException("Leilão já encerrado");
		}
		return repo.save(item);
	}

	public ItemDeLeilao encerraLeilao(Long id) {
		ItemDeLeilao item = repo.findById(id).get();
		item.setLeilaoAberto(false);
		return repo.save(item);
	}

}
