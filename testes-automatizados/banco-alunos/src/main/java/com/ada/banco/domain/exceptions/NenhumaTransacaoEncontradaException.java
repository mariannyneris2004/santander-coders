package com.ada.banco.domain.exceptions;

public class NenhumaTransacaoEncontradaException extends RuntimeException{
    public NenhumaTransacaoEncontradaException() {
        super("Nenhuma transação foi encontrada!");
    }
}
