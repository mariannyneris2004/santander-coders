package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class Sacar {
    private SaqueGateway saqueGateway;

    public Sacar(SaqueGateway saqueGateway) {
        this.saqueGateway = saqueGateway;
    }
    public Conta execute(Conta conta, BigDecimal valor) throws Exception {
        Conta contaSaque = saqueGateway.sacar(conta, valor);

        if (contaSaque == null) {
            // - se possuir vamos lancar uma exception
            throw new Exception("Não foi possível executar saque.");
        }

        return contaSaque;
    }
}
