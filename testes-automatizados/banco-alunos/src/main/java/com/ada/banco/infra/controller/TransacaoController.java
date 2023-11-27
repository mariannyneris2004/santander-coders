package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transacao;
import com.ada.banco.domain.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private Depositar depositar;
    private BuscarConta buscarConta;
    private BuscarTransacao buscarTransacao;
    private ListarTransacoes listarTransacoes;
    private Sacar sacar;
    private Transferir transferir;

    public TransacaoController(Depositar depositar, BuscarConta buscarConta, BuscarTransacao buscarTransacao,
                               ListarTransacoes listarTransacoes, Sacar sacar, Transferir transferir) {
        this.depositar = depositar;
        this.buscarConta = buscarConta;
        this.buscarTransacao = buscarTransacao;
        this.listarTransacoes = listarTransacoes;
        this.sacar = sacar;
        this.transferir = transferir;
    }

    @PostMapping("/depositar")
    public ResponseEntity depositar(@RequestBody Transacao transacao) throws Exception {
        Transacao novaTransacao;
        try {
            novaTransacao = depositar.execute(transacao);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao.toString());
    }

    @PostMapping("/sacar")
    public ResponseEntity sacar(@RequestBody Transacao transacao) throws Exception {
        Transacao novaTransacao;
        try {
            novaTransacao = sacar.execute(transacao);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao.toString());
    }

    @PostMapping("/transferir")
    public ResponseEntity transferir(@RequestBody Transacao transacao) throws Exception {
        Transacao novaTransacao;
        try {
            novaTransacao = transferir.execute(transacao);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao.toString());
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() throws Exception {
        List<Transacao> transacoes = listarTransacoes.execute();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarTransacaoPorConta(@PathVariable Long id) {
        try {
            Conta conta = buscarConta.buscarPorId(id);
            if (conta != null) {
                List<Transacao> transacoes = buscarTransacao.execute(conta);
                if (transacoes != null) {
                    return ResponseEntity.ok(transacoes.toString());
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
