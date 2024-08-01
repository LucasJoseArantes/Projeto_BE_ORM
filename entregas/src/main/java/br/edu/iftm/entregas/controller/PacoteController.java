package br.edu.iftm.entregas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
        Optional<Pacote> pacote = pacoteService.getPacoteById(id);
        return pacote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /pacotes/{id} - Atualiza as informações de um pacote
    @PutMapping("/{id}")
    public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
        Optional<Pacote> updatedPacote = pacoteService.updatePacote(id, pacoteDetails);
        return updatedPacote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /pacotes/{id} - Remove um pacote
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacote(@PathVariable Long id) {
        if (pacoteService.deletePacote(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}