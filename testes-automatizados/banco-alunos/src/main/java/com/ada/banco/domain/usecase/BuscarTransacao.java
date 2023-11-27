package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.NenhumaTransacaoEncontradaException;
import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTransacao {
    private TransacaoGateway transacaoGateway;

    public BuscarTransacao(TransacaoGateway transacaoGateway) {
        this.transacaoGateway = transacaoGateway;
    }

    public List<Transacao> execute(Conta conta){
        List<Transacao> transacaos = transacaoGateway.buscarTransacoesPorConta(conta);

        if (transacaos == null){
            throw new NenhumaTransacaoEncontradaException();
        }

        return transacaos;
    }
}
