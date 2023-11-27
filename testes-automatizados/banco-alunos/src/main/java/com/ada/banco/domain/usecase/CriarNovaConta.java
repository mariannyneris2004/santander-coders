package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ClienteJaPossuiContaException;
import com.ada.banco.domain.gateway.ClienteGateway;
import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarNovaConta {
    private Cliente cliente = new Cliente();
    private ContaGateway contaGateway;
    private ClienteGateway clienteGateway;

    public CriarNovaConta(ContaGateway contaGateway, ClienteGateway clienteGateway) {
        this.contaGateway = contaGateway;
        this.clienteGateway = clienteGateway;
    }

    public Conta execute(Conta conta) throws Exception {
        cliente = clienteGateway.buscarPorId(conta.getCliente().getId());
        if (cliente != null){
            conta.setCliente(cliente);
            if (contaGateway.buscarPorCliente(conta.getCliente()) == null){
                contaGateway.salvar(conta);
                return conta;
            }
        }

        throw new ClienteJaPossuiContaException();
    }
}