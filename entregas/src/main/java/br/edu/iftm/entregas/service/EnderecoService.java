package br.edu.iftm.entregas.service;

import br.edu.iftm.entregas.model.Endereco;
import br.edu.iftm.entregas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos() {
        List<Endereco> lista = new ArrayList<Endereco>();
		enderecoRepository.findAll().forEach(p -> lista.add(p));
		return lista;
    }

    public Endereco addEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}