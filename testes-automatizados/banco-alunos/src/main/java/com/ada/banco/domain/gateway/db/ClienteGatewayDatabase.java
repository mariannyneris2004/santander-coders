package com.ada.banco.domain.gateway.db;

import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.gateway.ClienteRepository;
import com.ada.banco.domain.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGatewayDatabase implements ClienteGateway {
    private ClienteRepository clienteRepository;

    public ClienteGatewayDatabase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
