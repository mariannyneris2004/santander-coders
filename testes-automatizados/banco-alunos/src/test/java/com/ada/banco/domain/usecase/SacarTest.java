package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SacarTest {
    @Test
    public void deveLancarExcecaoAoSacar(){
        Sacar sacar = new Sacar();
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        Assertions.assertThrows(Exception.class, () -> sacar.execute(conta, new BigDecimal(500)));
    }

    @Test
    public void deveSacarCorretamente() throws Exception {
        Depositar depositar = new Depositar();

        Sacar sacar = new Sacar();

        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        depositar.execute(conta, new BigDecimal(500));
        sacar.execute(conta, new BigDecimal(200));

        Assertions.assertAll(() -> Assertions.assertEquals(new BigDecimal(300), conta.getSaldo()));
    }
}
