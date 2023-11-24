package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class CriarNovaContaTest {
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    CriarNovaConta criarNovaConta;

    @Test
    public void deveLancarUmaExcecaoCasoUsuarioJaPossuaUmaConta(){
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678909");

        Mockito.when(contaGateway.buscarPorCpf(conta.getCpf())).thenReturn(conta);
        Assertions.assertThrows(Exception.class, () -> criarNovaConta.execute(conta));

        Mockito.verify(contaGateway, Mockito.times(1)).buscarPorCpf(conta.getCpf());
        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception {
        Conta conta = new Conta(12345L, 0002L, 1L, BigDecimal.ZERO, "Marianny", "12345678901");

        Mockito.when(contaGateway.buscarPorCpf(conta.getCpf())).thenReturn(null);
        Mockito.when(contaGateway.salvar(conta)).thenReturn(conta);
        Conta novaConta = criarNovaConta.execute(conta);

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novaConta.getTitular()),
                                () -> Assertions.assertEquals("12345678901", novaConta.getCpf()));
    }
}
