package repositorio;

import modelos.Pedido;

import java.util.HashMap;
import java.util.Map;

public class PedidoRepositorio {
    private Map<Integer, Pedido> pedidos;

    public PedidoRepositorio() {
        this.pedidos = new HashMap<>();
    }

    public void add(Pedido pedido){
        pedido.setId(pedidos.size() + 1);

        this.pedidos.put(pedido.getId(), pedido);
    }

    public Pedido getPedido(String nome) {
        for (Pedido pedido : pedidos.values()) {
            if(pedido.getCliente().getNome().equals(nome)){
                return pedido;
            }
        }
        return null;
    }

    public Pedido getPedido(Integer id) {
        return pedidos.get(id);
    }

    public boolean delete(Integer id) {
        if (pedidos.get(id) != null) {
            pedidos.remove(id);
            return true;
        }

        return false;
    }

    public Map<Integer, Pedido> getPedidos() {
        return this.pedidos;
    }
}
