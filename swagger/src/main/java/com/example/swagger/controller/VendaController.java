package com.example.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Venda;
import com.example.swagger.service.VendaService;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // Retorna todos os itens que foram vendidos sem desconto
    @GetMapping("/sem-desconto")
    public List<Venda> getVendasSemDesconto() {
        return vendaService.getVendasSemDesconto();
    }

    // Retorna todos os itens que foram vendidos com desconto
    @GetMapping("/com-desconto")
    public List<Venda> getVendasComDesconto() {
        return vendaService.getVendasComDesconto();
    }

    // Retorna todos os itens e ordena o resultado por VALOR_UNIT do maior valor para o menor
    @GetMapping("/ordenado-por-valor")
    public List<Venda> getVendasOrdenadasPorValor() {
        return vendaService.getVendasOrdenadasPorValor();
    }

    // Retorna o produto que mais vendeu em uma mesma NF
    @GetMapping("/mais-vendido-na-nf/{idNf}")
    public List<Integer> getProdutoMaisVendidoNaNf(@PathVariable int idNf) {
        return vendaService.getProdutoMaisVendidoNaNf(idNf);
    }

    // Consulta as NF que foram vendidas mais de 10 unidades de pelo menos um produto
    @GetMapping("/nf-com-mais-dez-unidades")
    public List<Integer> getNfComMaisDezUnidadesVendidas() {
        return vendaService.getNfComMaisDezUnidadesVendidas();
    }

    // Pesquisa o valor total das NF, onde esse valor seja maior que 500, e ordena o resultado do maior valor para o menor
    @GetMapping("/nf-com-valor-maior-que-500")
    public List<Object[]> getNfComValorMaiorQue500() {
        return vendaService.getNfComValorMaiorQue500();
    }
    
}

