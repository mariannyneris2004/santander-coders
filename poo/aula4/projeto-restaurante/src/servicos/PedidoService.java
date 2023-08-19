package servicos;

import exceptions.ListaVaziaException;
import modelos.*;
import repositorio.PedidoRepositorio;

import java.util.HashMap;
import java.util.Map;

public class PedidoService {
    private static PedidoService uniqueInstance = new PedidoService();
    private PedidoService() {
    }

    public static PedidoService getInstance() {
        return uniqueInstance;
    }

    private PedidoRepositorio pedidoRepositorio = new PedidoRepositorio();

    public Pedido cadastrarPedido(Cliente cliente, Restaurante restaurante, String enderecoEntrega, Map<Integer, ItemPedido> itensPedido){
        Pedido pedido = new Pedido(cliente, restaurante, enderecoEntrega);
        for (ItemPedido itemPedido : itensPedido.values()) {
            pedido.adicionarItemPedido(itemPedido.getId(), itemPedido);
        }
        pedidoRepositorio.add(pedido);
        return pedido;
    }

    public Pedido getPedido(Integer id){
        return pedidoRepositorio.getPedido(id);
    }

    public Pedido getPedido(String nome){
        return pedidoRepositorio.getPedido(nome);
    }

    public Map<Integer, Pedido> getPedidos(){
        return pedidoRepositorio.getPedidos();
    }

    public boolean deletePedido(Integer id){
        return pedidoRepositorio.delete(id);
    }

    public boolean deletePedido(String nome){
        Pedido prato = pedidoRepositorio.getPedido(nome);
        return pedidoRepositorio.delete(prato.getId());
    }

    public Map<Integer, Pedido> listarPedidosRestaurante(Restaurante restaurante){
        Map<Integer, Pedido> pedidosDoRestaurante = new HashMap<>();
        for (Pedido pedido : getPedidos().values()) {
            if (pedido.getRestaurante().equals(restaurante)){
                pedidosDoRestaurante.put(pedido.getId(), pedido);
            }
        }

        return pedidosDoRestaurante;
    }

    public Map<Integer, Pedido> listarPedidosCliente(Cliente cliente){
        Map<Integer, Pedido> pedidosDoCliente = new HashMap<>();
        for (Pedido pedido : getPedidos().values()) {
            if (pedido.getCliente().equals(cliente)){
                pedidosDoCliente.put(pedido.getId(), pedido);
            }
        }
        if (!pedidosDoCliente.equals(null)){
            return pedidosDoCliente;
        }

        throw new ListaVaziaException("Nenhum cliente cadastrado!");
    }
}
