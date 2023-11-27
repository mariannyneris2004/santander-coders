package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteJaCadastradoException;
import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class CadastrarNovoCliente {
    private ClienteGateway clienteGateway;

    public CadastrarNovoCliente(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente execute(Cliente cliente) throws Exception {
        if (clienteGateway.buscarPorCpf(cliente.getCpf()) != null){
            throw new ClienteJaCadastradoException();
        }

        Cliente clienteCadastrado = clienteGateway.salvar(cliente);

        return clienteCadastrado;
    }
}
