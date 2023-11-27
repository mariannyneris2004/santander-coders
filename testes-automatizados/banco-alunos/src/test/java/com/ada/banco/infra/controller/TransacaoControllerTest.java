package com.ada.banco.infra.controller;

import com.ada.banco.domain.gateway.ContaRepository;
import com.ada.banco.domain.gateway.TransacaoRepository;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import com.ada.banco.domain.model.enums.TipoContaEnum;
import com.ada.banco.domain.model.enums.TipoTransacaoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void depositarComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(1L);

        Conta conta = new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA);

        String requestConta = objectMapper.writeValueAsString(conta);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        conta.setId(1L);

        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(200), conta);

        String requestTransacao = objectMapper.writeValueAsString(transacao);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/transacoes/depositar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestTransacao))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void sacarComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "1234", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(2L);

        Conta conta = new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA);

        String requestConta = objectMapper.writeValueAsString(conta);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        conta.setId(2L);

        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(200), conta);

        String requestTransacao = objectMapper.writeValueAsString(transacao);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/transacoes/sacar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestTransacao))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void transferirComSucesso() throws Exception {
        Cliente cliente = new Cliente("Marianny", "1235", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(3L);

        Conta conta = new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA);

        String requestConta = objectMapper.writeValueAsString(conta);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        conta.setId(3L);

        Cliente cliente2 = new Cliente("Marianny", "1232", "123456789", "endereço", "email@gmail.com");
        String requestCliente2 = objectMapper.writeValueAsString(cliente2);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente2))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente2.setId(4L);

        Conta conta2 = new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA);

        String requestConta2 = objectMapper.writeValueAsString(conta2);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta2))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        conta2.setId(4L);

        Transacao transacao = new Transacao(TipoTransacaoEnum.TRANSFERENCIA, new BigDecimal(200), conta, conta2);

        String requestTransacao = objectMapper.writeValueAsString(transacao);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/transacoes/transferir")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestTransacao))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void buscaTransacaoPorIdDaConta() throws Exception {
        Cliente cliente = new Cliente("Marianny", "1236", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(5L);

        Conta conta = new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA);
        String requestConta = objectMapper.writeValueAsString(conta);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        conta.setId(5L);

        Transacao transacao = new Transacao(TipoTransacaoEnum.SAQUE, new BigDecimal(200), conta);

        String requestTransacao = objectMapper.writeValueAsString(transacao);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/transacoes/sacar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestTransacao))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        transacao.setId(5L);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/transacoes/{id}", "5")
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }
}
