package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Cliente;

import java.util.List;

public interface ClienteGateway {
    Cliente buscarPorCpf(String cpf);
    Cliente buscarPorId(Long id);
    Cliente salvar(Cliente cliente);
    List<Cliente> listarClientes();
}
