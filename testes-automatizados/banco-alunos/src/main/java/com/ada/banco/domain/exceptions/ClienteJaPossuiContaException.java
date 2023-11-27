package com.ada.banco.domain.exceptions;

public class ClienteJaPossuiContaException extends RuntimeException{
    public ClienteJaPossuiContaException() {
        super("Cliente já possui conta!");
    }

}
