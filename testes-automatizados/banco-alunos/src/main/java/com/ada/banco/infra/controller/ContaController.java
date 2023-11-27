package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private CriarNovaConta criarNovaConta;
    private BuscarConta buscarConta;
    private BuscarCliente buscarCliente;
    private ListarContas listarContas;

    public ContaController(CriarNovaConta criarNovaConta, BuscarConta buscarConta, ListarContas listarContas,
                           BuscarCliente buscarCliente) {
        this.criarNovaConta = criarNovaConta;
        this.buscarConta = buscarConta;
        this.listarContas = listarContas;
        this.buscarCliente = buscarCliente;
    }

    @PostMapping
    public ResponseEntity criaConta(@RequestBody Conta conta) throws Exception {
        try {
            Conta novaConta = criarNovaConta.execute(conta);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<Conta>> listarContas() throws Exception {
        List<Conta> contas = listarContas.execute();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarContaPorId(@PathVariable Long id) {
        try {
            Conta conta = buscarConta.buscarPorId(id);
            if (conta != null) {
                return ResponseEntity.ok(conta.toString());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<String> buscarContaPorCliente(@PathVariable String cpf) {
        try {
            Cliente cliente = buscarCliente.buscarPorCpf(cpf);
            if (cliente != null) {
                Conta conta = buscarConta.buscarPorCliente(cliente);
                if (conta != null) {
                    return ResponseEntity.ok(conta.toString());
                } else {
                    return ResponseEntity.notFound().build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
