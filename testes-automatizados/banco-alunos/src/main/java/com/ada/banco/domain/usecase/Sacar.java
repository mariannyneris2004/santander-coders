package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class Sacar {
    public Conta execute(Conta conta, BigDecimal valor) throws Exception {
        if (valor.compareTo(BigDecimal.ZERO) == -1 ||
                valor.compareTo(BigDecimal.ZERO) == 0 ||
                valor.compareTo(conta.getSaldo()) == 1){
            throw new Exception("Não foi possível realizar saque.");
        }

        valor = conta.getSaldo().subtract(valor);
        conta.setSaldo(valor);
        return conta;
    }
}
