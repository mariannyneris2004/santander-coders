package service;

import model.Conta;
import utils.ValidarSenha;

import java.math.BigDecimal;

public class Transferencia {

    private final ValidarSenha validarSenha;

    public Transferencia(ValidarSenha validarSenha) {
        this.validarSenha = validarSenha;
    }

    public Conta execute(Conta origem, Conta destino, BigDecimal valor, String senha) {
        if (validarSenha.execute(origem, senha)) {
            transfereDinheiro(valor, origem, destino);
            System.out.println("Mensagem de integração com sistema de transferência interna");
        } else {
            System.out.println("Senha inválida. Tente novamente.");
        }
        return origem;
    }

    private void transfereDinheiro(BigDecimal valor, Conta origem, Conta destino) {
        if(valor.compareTo(origem.getSaldo()) > 0) {
            System.out.println("Saldo insuficiente");
        } else {
            origem.setSaldo(origem.getSaldo().subtract(valor));
            destino.setSaldo(destino.getSaldo().add(valor));
        }
    }
}
