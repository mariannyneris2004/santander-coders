package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class DepositoGatewayDummyImpl implements DepositoGateway {
    @Override
    public Conta depositar(Conta conta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) == -1 || valor.compareTo(BigDecimal.ZERO) == 0){
            return null;
        }

        valor = conta.getSaldo().add(valor);
        conta.setSaldo(valor);
        return conta;
    }
}
