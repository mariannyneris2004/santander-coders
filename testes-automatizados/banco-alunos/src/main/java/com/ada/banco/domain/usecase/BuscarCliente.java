package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteNaoEncontradoException;
import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class BuscarCliente {
    private ClienteGateway clienteGateway;

    public BuscarCliente(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente buscarPorCpf(String cpf) throws Exception {
        Cliente novoCliente = clienteGateway.buscarPorCpf(cpf);
        if (novoCliente == null){
            throw new ClienteNaoEncontradoException();
        }
        return novoCliente;
    }
}
