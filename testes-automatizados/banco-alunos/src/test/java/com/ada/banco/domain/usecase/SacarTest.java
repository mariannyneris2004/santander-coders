package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.DepositoGatewayDummyImpl;
import com.ada.banco.dummy.SaqueGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SacarTest {
    @Test
    public void deveLancarExcecaoAoSacar(){
        SaqueGateway saqueGateway = new SaqueGatewayDummyImpl();
        Sacar sacar = new Sacar(saqueGateway);
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        Assertions.assertThrows(Exception.class, () -> sacar.execute(conta, new BigDecimal(500)));
    }

    @Test
    public void deveSacarCorretamente() throws Exception {
        DepositoGateway depositoGateway = new DepositoGatewayDummyImpl();
        Depositar depositar = new Depositar(depositoGateway);

        SaqueGateway saqueGateway = new SaqueGatewayDummyImpl();
        Sacar sacar = new Sacar(saqueGateway);

        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        depositar.execute(conta, new BigDecimal(500));
        sacar.execute(conta, new BigDecimal(200));

        Assertions.assertAll(() -> Assertions.assertEquals(new BigDecimal(300), conta.getSaldo()));
    }
}
