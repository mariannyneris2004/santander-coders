package com.ada.banco.domain.model;

import com.ada.banco.domain.model.enums.TipoTransacaoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoTransacaoEnum tipo;
    private BigDecimal valor;

    @ManyToOne
    private Conta contaOrigem;

    @ManyToOne
    private Conta contaDestino;

    public Transacao(){}

    public Transacao(TipoTransacaoEnum tipo, BigDecimal valor, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public Transacao(TipoTransacaoEnum tipo, BigDecimal valor, Conta contaOrigem) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                '}';
    }
}
