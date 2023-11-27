package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteJaPossuiContaException;
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
public class CriarNovaContaTest {
    @Mock
    private ContaGateway contaGateway;
    @InjectMocks
    CriarNovaConta criarNovaConta;

    @Test
    public void deveLancarUmaExcecaoCasoClienteJaPossuaUmaConta(){
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorCliente(conta.getCliente())).thenReturn(conta);
        Throwable throwable = Assertions.assertThrows(ClienteJaPossuiContaException.class, () -> criarNovaConta.execute(conta));

        Assertions.assertEquals("Cliente já possui conta!", throwable.getMessage());

        Mockito.verify(contaGateway, Mockito.times(1)).buscarPorCliente(conta.getCliente());
        Mockito.verify(contaGateway, Mockito.never()).salvar(conta);
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "1234", "endereço", "email@gmail.com");
        Conta conta = new Conta(12345L, 0002L, BigDecimal.ZERO, cliente, TipoContaEnum.POUPANCA);

        Mockito.when(contaGateway.buscarPorCliente(conta.getCliente())).thenReturn(null);
        Mockito.when(contaGateway.salvar(conta)).thenReturn(conta);
        Conta novaConta = criarNovaConta.execute(conta);

        Assertions.assertAll(() -> Assertions.assertEquals("Marianny", novaConta.getCliente().getNome()),
                                () -> Assertions.assertEquals(TipoContaEnum.POUPANCA, novaConta.getTipoConta()));
    }
}
