package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import com.ada.banco.domain.model.enums.TipoTransacaoEnum;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Transferir {
    private TransacaoGateway transacaoGateway;
    private ContaGateway contaGateway;

    public Transferir(TransacaoGateway transacaoGateway, ContaGateway contaGateway) {
        this.transacaoGateway = transacaoGateway;
        this.contaGateway = contaGateway;
    }

    public Transacao execute(Transacao transacao) throws Exception {
        Conta contaOrigem = contaGateway.buscarPorId(transacao.getContaOrigem().getId());
        Conta contaDestino = contaGateway.buscarPorId(transacao.getContaDestino().getId());

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);

        if (transacao.getValor().compareTo(BigDecimal.ZERO) == -1 ||
            transacao.getValor().compareTo(BigDecimal.ZERO) == 0 ||
            transacao.getValor().compareTo(transacao.getContaOrigem().getSaldo()) == 1){
            throw new Exception("Não foi possível realizar transferência.");
        }

        BigDecimal valorDeposito = contaDestino.getSaldo().add(transacao.getValor());
        BigDecimal valorSaque = contaOrigem.getSaldo().subtract(transacao.getValor());

        contaOrigem.setSaldo(valorSaque);
        contaDestino.setSaldo(valorDeposito);

        contaGateway.salvar(contaDestino);
        contaGateway.salvar(contaOrigem);

        Transacao novaTransacao = new Transacao(TipoTransacaoEnum.TRANSFERENCIA, transacao.getValor(), contaOrigem, contaDestino);
        transacaoGateway.salvar(transacao);

        return novaTransacao;
    }
}
