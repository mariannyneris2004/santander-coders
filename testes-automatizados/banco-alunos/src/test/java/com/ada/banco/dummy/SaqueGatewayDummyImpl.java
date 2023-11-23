package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class SaqueGatewayDummyImpl implements SaqueGateway {
    @Override
    public Conta sacar(Conta conta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) == -1 ||
                valor.compareTo(BigDecimal.ZERO) == 0 ||
                valor.compareTo(conta.getSaldo()) == 1){
            return null;
        }

        valor = conta.getSaldo().subtract(valor);
        conta.setSaldo(valor);
        return conta;
    }
}
