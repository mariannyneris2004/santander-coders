package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.gateway.TransacaoGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import com.ada.banco.domain.model.enums.TipoTransacaoEnum;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Sacar {
    private TransacaoGateway transacaoGateway;
    private ContaGateway contaGateway;

    public Sacar(TransacaoGateway transacaoGateway, ContaGateway contaGateway) {
        this.transacaoGateway = transacaoGateway;
        this.contaGateway = contaGateway;
    }

    public Transacao execute(Transacao transacao) throws Exception {
        Conta conta = contaGateway.buscarPorId(transacao.getContaOrigem().getId());

        transacao.setContaOrigem(conta);

        if (transacao.getValor().compareTo(BigDecimal.ZERO) == -1 ||
            transacao.getValor().compareTo(BigDecimal.ZERO) == 0 ||
            transacao.getValor().compareTo(transacao.getContaOrigem().getSaldo()) == 1){
            throw new Exception("Não foi possível realizar saque.");
        }

        BigDecimal valor = transacao.getContaOrigem().getSaldo().subtract(transacao.getValor());
        transacao.getContaOrigem().setSaldo(valor);

        Conta novaConta = contaGateway.salvar(transacao.getContaOrigem());
        transacao.setContaOrigem(novaConta);
        Transacao saque = transacaoGateway.salvar(transacao);

        return saque;
    }
}
