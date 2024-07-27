package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.LanceService;

@RestController
@RequestMapping("/lance")
public class LanceController {

	@Autowired
	private LanceService service;

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public Lance lance(@PathVariable Long id) {
		return service.busca(id);
	}

	@PutMapping("/{id}")
	public Lance atualiza(@RequestBody Lance lance, @PathVariable Long id) {
		return service.atualiza(lance, id);
	}

	@GetMapping
	public List<Lance> lances() {
		return service.lances();
	}

}
