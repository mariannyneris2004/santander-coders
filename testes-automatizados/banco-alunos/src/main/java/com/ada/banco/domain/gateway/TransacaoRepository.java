package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByContaOrigem(Conta contaOrigem);
    List<Transacao> findByContaDestino(Conta contaDestino);
}
