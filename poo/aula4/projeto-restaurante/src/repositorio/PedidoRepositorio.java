package repositorio;

import modelos.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio {
    private List<Pedido> pedidos;

    public PedidoRepositorio() {
        this.pedidos = new ArrayList<>();
    }

    public void add(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public Pedido getPedidos(String nome) {
        for (Pedido pedido : pedidos) {
            if(pedido.getNomeCliente().equals(nome)){
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> pedidosAnteriores(){
        return pedidos;
    }
}
