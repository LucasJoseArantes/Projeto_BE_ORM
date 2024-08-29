package com.example.swagger.service.exceptions;

public class VendaNaoEncontradaException extends RuntimeException {
    public VendaNaoEncontradaException(String message) {
        super(message);
    }
}
