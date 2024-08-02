package br.edu.iftm.entregas.service;

import br.edu.iftm.entregas.model.Pacote;
import br.edu.iftm.entregas.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Pacote getPacoteById(int id) {
        return pacoteRepository.findById(id).get();
    }

    public Pacote updatePacote(int id, Pacote item) {
        Pacote itemExistente = pacoteRepository.findById(id).get();
        itemExistente.setDestinatario(item.getDestinatario());
        itemExistente.setEndereco(item.getEndereco());
        itemExistente.setStatus(item.getStatus());
		return pacoteRepository.save(itemExistente);
    }

    public void deletePacote(int id) {
        pacoteRepository.deleteById(id);
    }
}