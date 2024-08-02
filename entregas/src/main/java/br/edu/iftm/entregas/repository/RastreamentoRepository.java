package br.edu.iftm.entregas.repository;

import br.edu.iftm.entregas.model.Rastreamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreamentoRepository extends JpaRepository<Rastreamento, Integer> {
}