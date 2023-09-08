package model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta{
    private BigDecimal limite;

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public boolean possoRetirarOValor(BigDecimal valor) {
        return this.getSaldo().add(limite).compareTo(valor) > 0;
    }
}
