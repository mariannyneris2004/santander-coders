package tech.ada.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }


    public List<Cliente> buscarTodosOsClientes() {
        List<Cliente> clientes = clienteRepo.findAll();
        return clientes;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> optCliente = clienteRepo.findById(id);
        return optCliente.orElseThrow(() -> new RuntimeException("Não existe cliente com esse id"));
    }

    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientes = clienteRepo.findByNomeCompletoCustom(nome);
        return clientes;
    }

    public void ativarDesativarCliente(boolean ativo, Long id) {
        clienteRepo.ativarUsuario(ativo, id);
    }

}