package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteNaoEncontradoException;
import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.gateway.ClienteGateway;
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
public class BuscarClienteTest {
    @Mock
    private ClienteGateway clienteGateway;
    @InjectMocks
    BuscarCliente buscarCliente;

    @Test
    public void deveLancarUmaExcecaoCasoClienteNaoSejaEncontrado(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");

        Mockito.when(clienteGateway.buscarPorCpf(cliente.getCpf())).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(ClienteNaoEncontradoException.class, () -> buscarCliente.buscarPorCpf(cliente.getCpf()));

        Assertions.assertEquals("Nenhum cliente encontrado!", throwable.getMessage());

        Mockito.verify(clienteGateway, Mockito.times(1)).buscarPorCpf(cliente.getCpf());
    }

    @Test
    public void deveBuscarClienteComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");

        Mockito.when(clienteGateway.buscarPorCpf(cliente.getCpf())).thenReturn(cliente);
        Cliente novoCliente = buscarCliente.buscarPorCpf(cliente.getCpf());

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novoCliente.getNome()),
                                () -> Assertions.assertEquals("123", novoCliente.getCpf()));
    }

}
