package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public interface DepositoGateway {
    Conta depositar(Conta conta, BigDecimal valor);

}
