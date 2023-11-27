package com.ada.banco.domain.usecase;

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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListarContasTest {
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    ListarContas listarContas;

    @Test
    public void deveLancarUmaExcecaoCasoNenhumaContaSejaEncontrada(){
        Mockito.when(contaGateway.buscarContas()).thenReturn(null);
        Throwable throwable = Assertions.assertThrows(ContaNaoEncontradaException.class, () -> listarContas.execute());

        Assertions.assertEquals("Nenhuma conta encontrada!", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.times(1)).buscarContas();
    }

    @Test
    public void deveListarContasComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        List<Conta> contas = List.of(conta);
        Mockito.when(contaGateway.buscarContas()).thenReturn(contas);
        List<Conta> listaContas = listarContas.execute();

        Assertions.assertEquals(contas, listaContas);

        Mockito.verify(contaGateway, Mockito.times(1)).buscarContas();
    }
}
