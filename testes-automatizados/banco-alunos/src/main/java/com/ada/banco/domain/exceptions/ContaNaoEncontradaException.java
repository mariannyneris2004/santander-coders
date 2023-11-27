package com.ada.banco.domain.exceptions;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException() {
        super("Nenhuma conta encontrada!");
    }
}
