package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import com.ada.banco.domain.model.enums.TipoContaEnum;
import com.ada.banco.domain.model.enums.TipoTransacaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class SacarTest {
    @Mock
    private TransacaoGateway transacaoGateway;
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    Sacar sacar;
    @Test
    public void deveLancarExcecaoAoSacarValorNegativo(){
        Sacar sacar = new Sacar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(500), conta);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> sacar.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar saque.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveLancarExcecaoAoSacarZero(){
        Sacar sacar = new Sacar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, BigDecimal.ZERO, conta);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> sacar.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar saque.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveLancarExcecaoAoSacarValorMaiorQueSaldo() throws Exception {
        Sacar sacar = new Sacar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.TEN, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(500), conta);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> sacar.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar saque.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveSacarCorretamente() throws Exception {
        Sacar sacar = new Sacar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, new BigDecimal(200), cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(200), conta);

        sacar.execute(transacao);

        Assertions.assertAll(() -> Assertions.assertEquals(new BigDecimal(0), conta.getSaldo()));
    }
}
