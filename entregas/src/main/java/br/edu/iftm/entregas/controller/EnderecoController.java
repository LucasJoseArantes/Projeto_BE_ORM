package br.edu.iftm.entregas.controller;

import org.springframework.web.bind.annotation.*;

import br.edu.iftm.entregas.model.Endereco;
import br.edu.iftm.entregas.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

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