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
public class TransferirTest {
    @Mock
    private TransacaoGateway transacaoGateway;
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    Transferir transferir;
    @InjectMocks
    Transacao transacao;
    @Test
    public void deveLancarExcecaoAoTransferirValorNegativo(){
        Cliente cliente1 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaOrigem = new Conta(12345L, 0002L, new BigDecimal(1000), cliente1, TipoContaEnum.POUPANCA);

        Cliente cliente2 = new Cliente("Marianny", "1234", "1234", "endereço", "email@gmail.com");
        Conta contaDestino = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente2, TipoContaEnum.POUPANCA);

        transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(-500), contaOrigem, contaDestino);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> transferir.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar transferência.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(contaDestino);
        Mockito.verify(contaGateway, Mockito.never()).salvar(contaOrigem);
    }

    @Test
    public void deveLancarExcecaoAoTransferirZero(){
        Cliente cliente1 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaOrigem = new Conta(12345L, 0002L, new BigDecimal(1000), cliente1, TipoContaEnum.POUPANCA);

        Cliente cliente2 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaDestino = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente2, TipoContaEnum.POUPANCA);

        transacao = new Transacao(TipoTransacaoEnum.SAQUE, BigDecimal.ZERO, contaOrigem, contaDestino);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> transferir.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar transferência.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(contaDestino);
        Mockito.verify(contaGateway, Mockito.never()).salvar(contaOrigem);
    }

    @Test
    public void deveLancarExcecaoAoTransferirValorMaiorQueSaldo() throws Exception {
        Cliente cliente1 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaOrigem = new Conta(12345L, 0002L, new BigDecimal(400), cliente1, TipoContaEnum.POUPANCA);

        Cliente cliente2 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaDestino = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente2, TipoContaEnum.POUPANCA);

        transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(500), contaOrigem, contaDestino);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> transferir.execute(transacao));

        Assertions.assertEquals("Não foi possível realizar transferência.", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.never()).salvar(contaDestino);
        Mockito.verify(contaGateway, Mockito.never()).salvar(contaOrigem);
    }

    @Test
    public void deveTransferirCorretamente() throws Exception {
        Cliente cliente1 = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta contaOrigem = new Conta(12345L, 0002L, new BigDecimal(400), cliente1, TipoContaEnum.POUPANCA);
        contaOrigem.setId(1L);

        Cliente cliente2 = new Cliente("Marianny", "1234", "1234", "endereço", "email@gmail.com");
        Conta contaDestino = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente2, TipoContaEnum.POUPANCA);
        contaDestino.setId(2L);

        transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(200), contaOrigem, contaDestino);

        Transacao novaTransacao = transferir.execute(transacao);

        Assertions.assertAll(() -> Assertions.assertEquals(new BigDecimal(200), novaTransacao.getContaDestino().getSaldo()),
                () -> Assertions.assertEquals(new BigDecimal(200), novaTransacao.getContaOrigem().getSaldo()));

        Mockito.verify(contaGateway, Mockito.times(1)).salvar(contaDestino);
        Mockito.verify(contaGateway, Mockito.times(1)).salvar(contaOrigem);

        Mockito.verify(transacaoGateway, Mockito.times(1)).salvar(transacao);
    }
}
