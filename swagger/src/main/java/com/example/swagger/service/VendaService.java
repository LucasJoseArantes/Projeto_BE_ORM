package com.example.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.model.Venda;
import com.example.swagger.repository.VendaRepository;
import com.example.swagger.service.exceptions.VendaNaoEncontradaException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda getVendaById(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new VendaNaoEncontradaException("Venda não encontrada com o id: " + id));
    }

    public List<Venda> getVendasSemDesconto() {
        return vendaRepository.findByDesconto(BigDecimal.ZERO);
    }

    public List<Venda> getVendasComDesconto() {
        return vendaRepository.findByDescontoGreaterThan(BigDecimal.ZERO);
    }

    public List<Venda> getVendasOrdenadasPorValor() {
        return vendaRepository.findAllByOrderByValorUnitDesc();
    }

    public List<Integer> getProdutoMaisVendidoNaNf(int idNf) {
        return vendaRepository.findTopSellingProductInNf(idNf);
    }

    public List<Integer> getNfComMaisDezUnidadesVendidas() {
        return vendaRepository.findNfWithMoreThanTenUnits();
    }

    public List<Object[]> getNfComValorMaiorQue500() {
        return vendaRepository.findByTotalGreaterThan500();
    }
}
