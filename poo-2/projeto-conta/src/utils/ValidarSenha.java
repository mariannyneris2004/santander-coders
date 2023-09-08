package utils;

import model.Conta;
import utils.Criptografia;

public class ValidarSenha {

    private ValidarSenha() {
    }

    public boolean execute(Conta conta, String senha) {
        return conta.getSenha().equals(Criptografia.criptografar(senha));
    }
}