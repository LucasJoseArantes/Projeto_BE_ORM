package br.edu.iftm.entregas.service;

import br.edu.iftm.entregas.model.Endereco;
import br.edu.iftm.entregas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco addEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}