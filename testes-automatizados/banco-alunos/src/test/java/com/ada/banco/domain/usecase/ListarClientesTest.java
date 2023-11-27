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

import java.lang.ref.Cleaner;
import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListarClientesTest {
    @Mock
    private ClienteGateway clienteGateway;
    @InjectMocks
    ListarClientes listarClientes;

    @Test
    public void deveLancarUmaExcecaoCasoNenhumClienteSejaEncontrado(){
        Mockito.when(clienteGateway.listarClientes()).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(ClienteNaoEncontradoException.class, () -> listarClientes.execute());

        Assertions.assertEquals("Nenhum cliente encontrado!", throwable.getMessage());

        Mockito.verify(clienteGateway, Mockito.times(1)).listarClientes();
    }

    @Test
    public void deveListarClientesComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");

        List<Cliente> clientes = List.of(cliente);
        Mockito.when(clienteGateway.listarClientes()).thenReturn(clientes);
        List<Cliente> listaClientes = listarClientes.execute();

        Assertions.assertEquals(clientes, listaClientes);

        Mockito.verify(clienteGateway, Mockito.times(1)).listarClientes();
    }
}
