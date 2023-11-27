package com.ada.banco.domain.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException() {
        super("Nenhum cliente encontrado!");
    }
}
