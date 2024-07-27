package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.ItemdeLeilaoService;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {

	@Autowired
	private ItemdeLeilaoService service;

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public ItemDeLeilao item(@PathVariable Long id) {
		return service.busca(id);
	}

	@PutMapping("/{id}")
	public ItemDeLeilao atualiza(@PathVariable Long id, @RequestBody ItemDeLeilao item) {
		return service.atualiza(id, item);
	}

	@PostMapping
	public ItemDeLeilao novo(@RequestBody ItemDeLeilao item) {
		return service.salva(item);
	}

	@GetMapping
	public List<ItemDeLeilao> itens() {
		return service.itens();
	}

	@PostMapping("/{id}")
	public ItemDeLeilao registraLance(@RequestBody Lance lance, @PathVariable Long id) {
		return service.registraLance(lance, id);		
	}
	
	@PatchMapping("/{id}")
	public ItemDeLeilao encerraLeilao(@PathVariable Long id) {
		return service.encerraLeilao(id);
	}


}
