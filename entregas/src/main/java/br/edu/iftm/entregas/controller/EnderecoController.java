package br.edu.iftm.entregas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    // GET /enderecos - Consulta todos os endereços
    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    // POST /enderecos - Adiciona um novo endereço
    @PostMapping
    public Endereco addEndereco(@RequestBody Endereco endereco) {
        return enderecoService.addEndereco(endereco);
    }
}