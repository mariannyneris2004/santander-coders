package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;

import java.util.List;

public interface TransacaoGateway {
    Transacao salvar(Transacao transacao);
    List<Transacao> buscarTransacoesPorConta(Conta conta);
    List<Transacao> listarTransacoes();
}
