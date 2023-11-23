package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.ContaGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CriarNovaContaTest {
    @Test
    public void deveLancarUmaExcecaoCasoUsuarioJaPossuaUmaConta(){
        ContaGateway contaGateway = new ContaGatewayDummyImpl();
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        Assertions.assertThrows(Exception.class, () -> criarNovaConta.execute(conta));
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception {
        ContaGateway contaGateway = new ContaGatewayDummyImpl();
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678901");

        Conta novaConta = criarNovaConta.execute(conta);

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novaConta.getTitular()),
                                () -> Assertions.assertEquals("12345678901", novaConta.getCpf()));
    }
}
