package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;

import java.util.List;

public interface ContaGateway {
    Conta buscarPorId(Long id);
    Conta buscarPorCliente(Cliente cliente);
    Conta salvar(Conta conta);
    List<Conta> buscarContas();
}
