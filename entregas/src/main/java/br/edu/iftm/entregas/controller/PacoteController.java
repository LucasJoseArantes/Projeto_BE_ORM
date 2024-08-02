package br.edu.iftm.entregas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.entregas.model.Pacote;
import br.edu.iftm.entregas.service.PacoteService;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    // GET /pacotes - Consulta todos os pacotes
    @GetMapping
    public List<Pacote> getAllPacotes() {
        return pacoteService.getAllPacotes();
    }

    // POST /pacotes - Adiciona um novo pacote
    @PostMapping
    public Pacote addPacote(@RequestBody Pacote pacote) {
        return pacoteService.addPacote(pacote);
    }

    // GET /pacotes/{id} - Consulta um pacote específico
    @GetMapping("/{id}")
    public Pacote getPacoteById(@PathVariable int id) {
        return pacoteService.getPacoteById(id);
    }

    // PUT /pacotes/{id} - Atualiza as informações de um pacote
    @PutMapping("/{id}")
    public Pacote updatePacote(@PathVariable int id, @RequestBody Pacote pacote) {
        return pacoteService.updatePacote(id, pacote);
    }

    // DELETE /pacotes/{id} - Remove um pacote
    @DeleteMapping("/{id}")
    public void deletePacote(@PathVariable int id) {
        pacoteService.deletePacote(id);
    }
}