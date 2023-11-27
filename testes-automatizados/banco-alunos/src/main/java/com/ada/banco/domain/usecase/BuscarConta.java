package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class BuscarConta {
    private ContaGateway contaGateway;

    public BuscarConta(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public Conta buscarPorCliente(Cliente cliente) throws Exception {
        Conta novaConta = contaGateway.buscarPorCliente(cliente);
        if (novaConta == null){
            throw new ContaNaoEncontradaException();
        }

        return novaConta;
    }

    public Conta buscarPorId(Long id) throws Exception {
        Conta novaConta = contaGateway.buscarPorId(id);
        if (novaConta == null){
            throw new ContaNaoEncontradaException();
        }

        return novaConta;
    }
}
