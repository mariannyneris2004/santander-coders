package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.exceptions.NenhumaTransacaoEncontradaException;
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
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BuscarTransacaoTest {
    @Mock
    private TransacaoGateway transacaoGateway;
    @InjectMocks
    BuscarTransacao buscarTransacao;

    @Test
    public void deveLancarUmaExcecaoCasoNenhumaTransacaoSejaEncontradaProcurandoPorConta(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(transacaoGateway.buscarTransacoesPorConta(conta)).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(NenhumaTransacaoEncontradaException.class, () -> buscarTransacao.execute(conta));

        Assertions.assertEquals("Nenhuma transação foi encontrada!", throwable.getMessage());

        Mockito.verify(transacaoGateway, Mockito.times(1)).buscarTransacoesPorConta(conta);
    }

    @Test
    public void deveBuscarContaPorClienteComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Transacao transacao = new Transacao(TipoTransacaoEnum.DEPOSITO, BigDecimal.TEN, conta);
        List<Transacao> transacoes = List.of(transacao);

        Mockito.when(transacaoGateway.buscarTransacoesPorConta(conta)).thenReturn(transacoes);
        List<Transacao> listaTransacoes = buscarTransacao.execute(conta);

        Assertions.assertEquals(transacoes, listaTransacoes);
    }

}
