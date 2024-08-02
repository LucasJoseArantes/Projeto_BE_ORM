package br.edu.iftm.entregas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.entregas.model.Rastreamento;
import br.edu.iftm.entregas.service.RastreamentoService;


@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    // GET /rastreamentos/{id} - Consulta todos os rastreamentos de um pacote específico
    @GetMapping("/{id}")
    public Rastreamento getRastreamentosByPacoteId(@PathVariable int id) {
        return rastreamentoService.getRastreamentosByPacoteId(id);
    }
}
