package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class Depositar {
    public Conta execute(Conta conta, BigDecimal valor) throws Exception {
        if (valor.compareTo(BigDecimal.ZERO) == -1 || valor.compareTo(BigDecimal.ZERO) == 0){
            throw new Exception("Não foi possível realizar depósito.");
        }

        valor = conta.getSaldo().add(valor);
        conta.setSaldo(valor);
        return conta;
    }
}
