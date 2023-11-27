package com.ada.banco.infra.controller;

import aj.org.objectweb.asm.TypeReference;
import com.ada.banco.domain.gateway.ClienteRepository;
import com.ada.banco.domain.model.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteController clienteController;

    @Test
    @DisplayName("Cria cliente com sucesso (Status 201) e com bad request (ao tentar cadastrar mesmo cliente)")
    public void criaCliente() throws Exception {
        String requestCliente = objectMapper.writeValueAsString(
                new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com"));

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        String requestCliente2 = objectMapper.writeValueAsString(
                new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com"));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

    @Test
    public void verificaMetodoCadastraCliente() throws Exception {
        Cliente cliente = new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com");

        clienteController.caadastraCliente(cliente);

        Cliente clienteCriado = clienteRepository.findByCpf("123");
        Assertions.assertEquals("123", clienteCriado.getCpf());
    }

    @Test
    public void buscaClientes() throws Exception {
        String requestCliente1 = objectMapper.writeValueAsString(
                new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com"));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente1))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        String requestCliente2 = objectMapper.writeValueAsString(
                new Cliente("OutroCliente", "456", "987654321", "outroEndereco", "outroemail@gmail.com"));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente2))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/clientes")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        List<Cliente> clientes = objectMapper.readValue(response, ArrayList.class);
        Assertions.assertFalse(clientes.isEmpty());
    }

    @Test
    public void buscaClientePorCpf() throws Exception {
        String requestCliente = objectMapper.writeValueAsString(
                new Cliente("Marianny", "123", "123456789", "endereço", "email@gmail.com"));

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/clientes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestCliente))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/clientes/{cpf}", "123")
                                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

}
