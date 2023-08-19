package servicos;

import exceptions.ListaVaziaException;
import exceptions.ObjetoNaoEcontradoException;
import modelos.Cliente;
import repositorio.ClienteRepositorio;

import java.util.Map;

public class ClienteService {
    private static ClienteService uniqueInstance = new ClienteService();

    private ClienteService() {
    }

    public static ClienteService getInstance() {
        return uniqueInstance;
    }

    private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

    public String cadastrarCliente(String nome){
        if (getCliente(nome) == null){
            Cliente cliente = new Cliente(nome);
            clienteRepositorio.add(cliente);
            return "Código do cliente: " + cliente.getId();
        } else {
            return "Código do cliente: " + getCliente(nome).getId();
        }
    }

    public Cliente getCliente(Integer id) throws ObjetoNaoEcontradoException{
        if (clienteRepositorio.getCliente(id).equals(null)){
            throw new ObjetoNaoEcontradoException("Cliente não encontrado!");
        }
        return clienteRepositorio.getCliente(id);
    }

    public Cliente getCliente(String nome) throws ObjetoNaoEcontradoException{
        return clienteRepositorio.getCliente(nome);
    }

    public boolean deleteCliente(Integer id){
        return clienteRepositorio.delete(id);
    }

    public boolean deleteCliente(String nome){
        Cliente cliente = clienteRepositorio.getCliente(nome);
        return clienteRepositorio.delete(cliente.getId());
    }

    public Map<Integer, Cliente> getClientes() throws ListaVaziaException {
        if (!clienteRepositorio.getClientes().equals(null)){
            return clienteRepositorio.getClientes();
        }
        throw new ListaVaziaException("Não há clientes cadastrados!");
    }

}
