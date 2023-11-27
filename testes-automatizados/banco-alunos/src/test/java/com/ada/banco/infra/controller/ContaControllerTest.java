package com.ada.banco.infra.controller;

import com.ada.banco.domain.gateway.ClienteRepository;
import com.ada.banco.domain.gateway.ContaRepository;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.enums.TipoContaEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class ContaControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    ContaController contaController;

    @Test
    @DisplayName("Cria conta com sucesso (Status 201) e com bad request (ao tentar cadastrar mesma conta)")
    public void criaCliente() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(1L);

        String requestConta = objectMapper.writeValueAsString(
                new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        String requestConta2 = objectMapper.writeValueAsString(
                new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

    @Test
    public void buscaContas() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(1L);

        String requestConta = objectMapper.writeValueAsString(
                new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Cliente cliente2 = new Cliente("OutroCliente", "1234", "123456789", "endereço", "email@gmail.com");
        String requestCliente2 = objectMapper.writeValueAsString(cliente2);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente2))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente2.setId(2L);

        String requestConta2 = objectMapper.writeValueAsString(
                new Conta(1234L, 2L, new BigDecimal(500), cliente2, TipoContaEnum.POUPANCA));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta2))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/contas")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        List<Cliente> clientes = objectMapper.readValue(response, ArrayList.class);
        Assertions.assertFalse(clientes.isEmpty());
    }

    @Test
    public void buscaContaPorId() throws Exception {
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

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/contas/{id}", "1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

    @Test
    public void buscaContaPorCpfDoCliente() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com");
        String requestCliente = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        cliente.setId(1L);

        String requestConta = objectMapper.writeValueAsString(
                new Conta(1234L, 2L, new BigDecimal(500), cliente, TipoContaEnum.POUPANCA));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/contas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestConta))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/contas/cpf/{cpf}", "123")
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }
}
