package com.ada.banco.domain.gateway.db;

import com.ada.banco.domain.exceptions.ContaNaoEncontradaException;
import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.gateway.ContaRepository;
import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContaGatewayDatabase implements ContaGateway {
    private ContaRepository contaRepository;

    public ContaGatewayDatabase(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta buscarPorId(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta == null){
            throw new ContaNaoEncontradaException();
        }
        return conta.get();
    }

    @Override
    public Conta buscarPorCliente(Cliente cliente) {
        Conta conta = contaRepository.findByCliente(cliente);
        if (conta == null){
            return null;
        }
        return conta;
    }

    @Override
    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public List<Conta> buscarContas() {
        return contaRepository.findAll();
    }
}
