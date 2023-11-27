package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteNaoEncontradoException;
import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarClientes {
    private ClienteGateway clienteGateway;

    public ListarClientes(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public List<Cliente> execute() throws Exception {
        List<Cliente> clientes = clienteGateway.listarClientes();
        if (clientes == null){
            throw new ClienteNaoEncontradoException();
        }

        return clientes;
    }
}
