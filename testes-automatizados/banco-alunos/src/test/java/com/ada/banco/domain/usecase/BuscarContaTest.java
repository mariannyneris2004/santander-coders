package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteJaPossuiContaException;
import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.enums.TipoContaEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class BuscarContaTest {
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    BuscarConta buscarConta;

    @Test
    public void deveLancarUmaExcecaoCasoContaNaoSejaEncontradaProcurandoPorCliente(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorCliente(conta.getCliente())).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(ContaNaoEncontradaException.class, () -> buscarConta.buscarPorCliente(conta.getCliente()));

        Assertions.assertEquals("Nenhuma conta encontrada!", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.times(1)).buscarPorCliente(conta.getCliente());
    }

    @Test
    public void deveBuscarContaPorClienteComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorCliente(conta.getCliente())).thenReturn(conta);
        Conta novaConta = buscarConta.buscarPorCliente(conta.getCliente());

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novaConta.getCliente().getNome()),
                                () -> Assertions.assertEquals(TipoContaEnum.POUPANCA, novaConta.getTipoConta()));
    }

    @Test
    public void deveLancarUmaExcecaoCasoContaNaoSejaEncontradaProcurandoPorId(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorId(conta.getId())).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(ContaNaoEncontradaException.class, () -> buscarConta.buscarPorId(conta.getId()));

        Assertions.assertEquals("Nenhuma conta encontrada!", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.times(1)).buscarPorId(conta.getId());
    }

    @Test
    public void deveBuscarContaPorIdComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorId(conta.getId())).thenReturn(conta);
        Conta novaConta = buscarConta.buscarPorId(conta.getId());

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novaConta.getCliente().getNome()),
                () -> Assertions.assertEquals(TipoContaEnum.POUPANCA, novaConta.getTipoConta()));
    }
}
