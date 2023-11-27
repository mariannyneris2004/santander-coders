package com.ada.banco.domain.model.enums;

public enum TipoTransacaoEnum {
    DEPOSITO("Depósito"),
    SAQUE("Saque"),
    TRANSFERENCIA("Tranferência");

    private String tipoTransacao;

    TipoTransacaoEnum(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }
}
