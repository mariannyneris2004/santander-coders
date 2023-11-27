package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findByCliente(Cliente cliente);
}
