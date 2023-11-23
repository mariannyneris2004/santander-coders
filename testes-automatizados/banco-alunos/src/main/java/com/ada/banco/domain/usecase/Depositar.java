package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class Depositar {
    private DepositoGateway depositoGateway;

    public Depositar(DepositoGateway depositoGateway) {
        this.depositoGateway = depositoGateway;
    }
    public Conta execute(Conta conta, BigDecimal valor) throws Exception {
        Conta contaDeposito = depositoGateway.depositar(conta, valor);

        if (contaDeposito == null) {
            // - se possuir vamos lancar uma exception
            throw new Exception("Não foi possível executar depósito.");
        }

        return contaDeposito;
    }
}
