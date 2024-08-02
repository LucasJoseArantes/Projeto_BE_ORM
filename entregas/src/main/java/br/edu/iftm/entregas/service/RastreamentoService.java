package br.edu.iftm.entregas.service;

import org.springframework.stereotype.Service;

import br.edu.iftm.entregas.model.Rastreamento;
import br.edu.iftm.entregas.repository.RastreamentoRepository;

@Service
public class RastreamentoService {
    private RastreamentoRepository rastreamentoRepository;

    public RastreamentoService(RastreamentoRepository rastreamentoRepository) {
        this.rastreamentoRepository = rastreamentoRepository;
    }

    public Rastreamento getRastreamentosByPacoteId(int id) {
        return rastreamentoRepository.findById(id).get();
    }

    public void deleteRastreamento(int id) {
        rastreamentoRepository.deleteById(id);
    }
}
