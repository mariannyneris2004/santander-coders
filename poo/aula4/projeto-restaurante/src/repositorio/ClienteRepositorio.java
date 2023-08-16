package repositorio;

import modelos.Cliente;
import java.util.HashMap;
import java.util.Map;

public class ClienteRepositorio {
    private Map<Integer, Cliente> clientes;

    public ClienteRepositorio() {
        this.clientes = new HashMap<>();
    }

    public void add(Cliente cliente){
        cliente.setId(clientes.size() + 1);

        this.clientes.put(cliente.getId(), cliente);
    }

    public Cliente getCliente(String nome) {
        for (Cliente cliente : clientes.values()) {
            if(cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        return null;
    }

    public Cliente getCliente(Integer id) {
        return clientes.get(id);
    }

    public boolean delete(Integer id) {
        if (clientes.get(id) != null) {
            clientes.remove(id);
            return true;
        }

        return false;
    }

    public Map<Integer, Cliente> getClientes() {
        return this.clientes;
    }
}
