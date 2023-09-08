package service;

import model.Conta;
import repository.ContaRepository;
import utils.Criptografia;

public class DefinirSenha {

    public Conta execute(Conta conta, String senha) {
        ContaRepository repository = new ContaRepository();
        conta.setSenha(Criptografia.criptografar(senha));
        return repository.update(conta);
    }

}