package com.example.swagger.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.swagger.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    // Retorna todos os itens que foram vendidos sem desconto
    List<Venda> findByDesconto(BigDecimal desconto);

    // Retorna todos os itens que foram vendidos com desconto
    List<Venda> findByDescontoGreaterThan(BigDecimal desconto);

    // Retorna todos os itens e ordena o resultado por VALOR_UNIT do maior valor para o menor
    List<Venda> findAllByOrderByValorUnitDesc();

    // Retorna o produto que mais vendeu em uma mesma NF
    @Query("SELECT v.codProd FROM Venda v WHERE v.idNf = ?1 GROUP BY v.codProd ORDER BY SUM(v.quantidade) DESC")
    List<Integer> findTopSellingProductInNf(int idNf);

    // Consulta as NF que foram vendidas mais de 10 unidades de pelo menos um produto
    @Query("SELECT v.idNf FROM Venda v WHERE v.quantidade > 10 GROUP BY v.idNf")
    List<Integer> findNfWithMoreThanTenUnits();

    // Pesquisa o valor total das NF, onde esse valor seja maior que 500, e ordena o resultado do maior valor para o menor
    @Query("SELECT v.idNf, SUM(v.valorUnit * v.quantidade) as total FROM Venda v GROUP BY v.idNf HAVING SUM(v.valorUnit * v.quantidade) > 500 ORDER BY total DESC")
    List<Object[]> findByTotalGreaterThan500();

}
