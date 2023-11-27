package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Cliente;
import com.ada.banco.domain.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private BuscarCliente buscarCliente;
    @Autowired
    private ListarClientes listarClientes;
    @Autowired
    private CadastrarNovoCliente cadastrarNovoCliente;

    @PostMapping
    public ResponseEntity cadastraCliente(@RequestBody Cliente cliente) throws Exception {
        Cliente novoCliente;
        try {
            novoCliente = cadastrarNovoCliente.execute(cliente);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes() throws Exception {
        List<Cliente> clientes = listarClientes.execute();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<String> buscarContaPorCpf(@PathVariable String cpf) {
        try {
            Cliente cliente = buscarCliente.buscarPorCpf(cpf);
            if (cliente != null) {
                return ResponseEntity.ok(cliente.toString());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
