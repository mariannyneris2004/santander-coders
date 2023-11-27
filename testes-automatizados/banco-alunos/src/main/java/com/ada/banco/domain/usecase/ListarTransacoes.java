package com.ada.banco.domain.usecase;

import com.ada.banco.domain.exceptions.NenhumaTransacaoEncontradaException;
import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTransacoes {
    private TransacaoGateway transacaoGateway;

    public ListarTransacoes(TransacaoGateway transacaoGateway) {
        this.transacaoGateway = transacaoGateway;
    }

    public List<Transacao> execute(){
        List<Transacao> transacaos = transacaoGateway.listarTransacoes();

        if (transacaos == null){
            throw new NenhumaTransacaoEncontradaException();
        }

        return transacaos;
    }
}
