package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.gateway.ContaRepository;
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
public class DepositarTest {
    @Mock
    private TransacaoGateway transacaoGateway;
    @Mock
    private ContaGateway contaGateway;
    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    Depositar depositar;
    @Test
    public void deveLancarExcecaoAoDepositarValorNegativo(){
        Depositar depositar = new Depositar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.DEPOSITO, new BigDecimal(-500), conta);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> depositar.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar depósito.", throwable.getMessage());
        
        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveLancarExcecaoAoDepositarZero(){
        Depositar depositar = new Depositar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.DEPOSITO, BigDecimal.ZERO, conta);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> depositar.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar depósito.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveDepositarCorretamente() throws Exception {
        Depositar depositar = new Depositar(transacaoGateway, contaGateway);
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        conta.setId(1L);
        Transacao transacao = new Transacao(TipoTransacaoEnum.DEPOSITO, new BigDecimal(500), conta);
        transacao.setId(1L);

        Mockito.when(contaGateway.buscarPorId(transacao.getContaOrigem().getId())).thenReturn(conta);

        Transacao transacaoDeposito = depositar.execute(transacao);

        Assertions.assertAll(
                () -> Assertions.assertEquals(new BigDecimal(500), transacaoDeposito.getContaOrigem().getSaldo()),
                () -> Mockito.verify(contaGateway, Mockito.times(1)).salvar(conta)
        );
    }

}
