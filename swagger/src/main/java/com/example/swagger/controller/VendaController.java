package com.example.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Venda;
import com.example.swagger.service.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@Tag(name = "vendas", description = "Endpoint for managing sales.")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/sem-desconto")
    @Operation(
        summary = "Get sales without discount.",
        description = "Returns all sales items that were sold without discount.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Venda.class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Venda> getVendasSemDesconto() {
        return vendaService.getVendasSemDesconto();
    }

    @GetMapping("/com-desconto")
    @Operation(
        summary = "Get sales with discount.",
        description = "Returns all sales items that were sold with discount.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Venda.class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Venda> getVendasComDesconto() {
        return vendaService.getVendasComDesconto();
    }

    @GetMapping("/ordenado-por-valor")
    @Operation(
        summary = "Get sales ordered by unit value.",
        description = "Returns all sales items ordered by unit value from highest to lowest.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Venda.class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Venda> getVendasOrdenadasPorValor() {
        return vendaService.getVendasOrdenadasPorValor();
    }

    @GetMapping("/mais-vendido-na-nf/{idNf}")
    @Operation(
        summary = "Get the most sold product in a specific NF.",
        description = "Returns the most sold product in a specific Nota Fiscal (NF) identified by the given ID.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Integer.class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Integer> getProdutoMaisVendidoNaNf(@PathVariable int idNf) {
        return vendaService.getProdutoMaisVendidoNaNf(idNf);
    }

    @GetMapping("/nf-com-mais-dez-unidades")
    @Operation(
        summary = "Get NFs with more than ten units sold.",
        description = "Returns Nota Fiscal (NF) where more than ten units of at least one product were sold.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Integer.class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Integer> getNfComMaisDezUnidadesVendidas() {
        return vendaService.getNfComMaisDezUnidadesVendidas();
    }

    @GetMapping("/nf-com-valor-maior-que-500")
    @Operation(
        summary = "Get NFs with a total value greater than 500.",
        description = "Returns Nota Fiscal (NF) with a total value greater than 500, ordered from highest to lowest value.",
        responses = {
            @ApiResponse(description = "Success.", responseCode = "200",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Object[].class)))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
        }
    )
    public List<Object[]> getNfComValorMaiorQue500() {
        return vendaService.getNfComValorMaiorQue500();
    }
}
