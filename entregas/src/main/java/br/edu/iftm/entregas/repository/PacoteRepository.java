package br.edu.iftm.entregas.repository;

import br.edu.iftm.entregas.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Integer> {
}