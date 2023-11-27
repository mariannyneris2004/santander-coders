package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarContas {
    private ContaGateway contaGateway;

    public ListarContas(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public List<Conta> execute() throws Exception {
        List<Conta> contas = contaGateway.buscarContas();
        if (contas == null){
            throw new ContaNaoEncontradaException();
        }

        return contas;
    }
}
