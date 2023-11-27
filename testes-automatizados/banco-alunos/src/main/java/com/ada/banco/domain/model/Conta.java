package com.ada.banco.domain.model;

import com.ada.banco.domain.model.enums.TipoContaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long agencia;
    private Long digito;
    private BigDecimal saldo;
    private TipoContaEnum tipoConta;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Conta(){}

    public Conta(Long agencia, Long digito, BigDecimal saldo, Cliente cliente, TipoContaEnum tipoConta) {
        this.agencia = agencia;
        this.digito = digito;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getDigito() {
        return digito;
    }

    public void setDigito(Long digito) {
        this.digito = digito;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", digito=" + digito +
                ", saldo=" + saldo +
                ", tipoConta=" + tipoConta +
                ", cliente=" + cliente +
                '}';
    }
}