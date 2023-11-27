package com.ada.banco.domain.exceptions;

public class ClienteJaCadastradoException extends RuntimeException{
    public ClienteJaCadastradoException() {
        super("Cliente já cadastrado!");
    }
}
