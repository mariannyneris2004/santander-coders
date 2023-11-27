package com.ada.banco.domain.model.enums;

public enum TipoContaEnum {
    POUPANCA("Poupança"),
    CORRENTE("Corrente");

    private String tipoConta;

    TipoContaEnum(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}

