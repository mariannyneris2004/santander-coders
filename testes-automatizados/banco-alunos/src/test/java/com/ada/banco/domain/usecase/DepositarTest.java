package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.DepositoGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DepositarTest {
    @Test
    public void deveLancarExcecaoAoDepositar(){
        DepositoGateway depositoGateway = new DepositoGatewayDummyImpl();
        Depositar depositar = new Depositar(depositoGateway);
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        Assertions.assertThrows(Exception.class, () -> depositar.execute(conta, new BigDecimal(-500)));
    }

    @Test
    public void deveDepositarCorretamente() throws Exception {
        DepositoGateway depositoGateway = new DepositoGatewayDummyImpl();
        Depositar depositar = new Depositar(depositoGateway);
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        depositar.execute(conta, new BigDecimal(500));

        Assertions.assertAll(() -> Assertions.assertEquals(new BigDecimal(500), conta.getSaldo()));
    }
}
