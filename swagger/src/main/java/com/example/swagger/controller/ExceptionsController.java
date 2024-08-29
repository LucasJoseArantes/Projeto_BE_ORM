package com.example.swagger.controller;

import com.example.swagger.service.exceptions.VendaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    // Captura e trata a exceção de venda não encontrada
    @ExceptionHandler(VendaNaoEncontradaException.class)
    public ResponseEntity<String> handleVendaNaoEncontrada(VendaNaoEncontradaException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
