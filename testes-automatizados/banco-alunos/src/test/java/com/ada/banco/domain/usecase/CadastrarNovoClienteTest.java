package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteJaCadastradoException;
import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarNovoClienteTest {
    @Mock
    private ClienteGateway clienteGateway;
    @InjectMocks
    CadastrarNovoCliente cadastrarNovoCliente;

    @Test
    public void deveLancarUmaExcecaoCasoClienteJaEstejaCadastrado(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");

        Mockito.when(clienteGateway.buscarPorCpf(cliente.getCpf())).thenReturn(cliente);
        Throwable throwable = Assertions.assertThrows(ClienteJaCadastradoException.class, () -> cadastrarNovoCliente.execute(cliente));

        Assertions.assertEquals("Cliente já cadastrado!", throwable.getMessage());

        Mockito.verify(clienteGateway, Mockito.times(1)).buscarPorCpf(cliente.getCpf());
        Mockito.verify(clienteGateway, Mockito.never()).salvar(cliente);
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");

        Mockito.when(clienteGateway.buscarPorCpf(cliente.getCpf())).thenReturn(null);
        Mockito.when(clienteGateway.salvar(cliente)).thenReturn(cliente);
        Cliente novoCliente = cadastrarNovoCliente.execute(cliente);

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novoCliente.getNome()),
                                () -> Assertions.assertEquals("123", novoCliente.getCpf()));
    }
}
