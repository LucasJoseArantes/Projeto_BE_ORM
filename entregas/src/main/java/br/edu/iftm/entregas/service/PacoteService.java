package br.edu.iftm.entregas.service;

import br.edu.iftm.entregas.model.Pacote;
import br.edu.iftm.entregas.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public List<Pacote> getAllPacotes() {
        return pacoteRepository.findAll();
    }

    public Pacote addPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Optional<Pacote> getPacoteById(Long id) {
        return pacoteRepository.findById(id);
    }

    public Optional<Pacote> updatePacote(Long id, Pacote pacoteDetails) {
        return pacoteRepository.findById(id).map(pacote -> {
            pacote.setDestinatario(pacoteDetails.getDestinatario());
            pacote.setEndereco(pacoteDetails.getEndereco());
            pacote.setStatus(pacoteDetails.getStatus());
            return pacoteRepository.save(pacote);
        });
    }

    public boolean deletePacote(Long id) {
        return pacoteRepository.findById(id).map(pacote -> {
            pacoteRepository.delete(pacote);
            return true;
        }).orElse(false);
    }
}