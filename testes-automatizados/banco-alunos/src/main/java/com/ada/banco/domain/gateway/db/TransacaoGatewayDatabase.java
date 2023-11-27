package com.ada.banco.domain.gateway.db;

import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.gateway.TransacaoRepository;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoGatewayDatabase implements TransacaoGateway {
    private TransacaoRepository transacaoRepository;

    public TransacaoGatewayDatabase(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public Transacao salvar(Transacao transacao) {
        transacaoRepository.save(transacao);
        return transacao;
    }

    @Override
    public List<Transacao> buscarTransacoesPorConta(Conta contaOrigem) {
        List<Transacao> transacoes = new ArrayList<>();
        List<Transacao> trasacoesContaOrigem = transacaoRepository.findByContaOrigem(contaOrigem);
        for (Transacao transacao:trasacoesContaOrigem) {
            transacoes.add(transacao);
        }
        List<Transacao> transacoesContaDestino = transacaoRepository.findByContaDestino(contaOrigem);
        for (Transacao transacao:transacoesContaDestino) {
            transacoes.add(transacao);
        }
        return transacoes;
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }
}
