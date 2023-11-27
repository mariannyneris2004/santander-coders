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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListarTransacoesTest {
    @Mock
    private TransacaoGateway transacaoGateway;
    @InjectMocks
    ListarTransacoes listarTransacoes;

    @Test
    public void deveLancarUmaExcecaoCasoNenhumaTransacaoNaoSejaEncontrada(){
        Mockito.when(transacaoGateway.listarTransacoes()).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(NenhumaTransacaoEncontradaException.class, () -> listarTransacoes.execute());

        Assertions.assertEquals("Nenhuma transação foi encontrada!", throwable.getMessage());

        Mockito.verify(transacaoGateway, Mockito.times(1)).listarTransacoes();
    }

    @Test
    public void deveListarTransacaoComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);
        Transacao transacao = new Transacao(TipoTransacaoEnum.DEPOSITO, BigDecimal.TEN, conta);

        List<Transacao> transacoes = List.of(transacao);
        Mockito.when(transacaoGateway.listarTransacoes()).thenReturn(transacoes);
        List<Transacao> listaTransacoes = listarTransacoes.execute();

        Assertions.assertEquals(transacoes, listaTransacoes);

        Mockito.verify(transacaoGateway, Mockito.times(1)).listarTransacoes();
    }
}
