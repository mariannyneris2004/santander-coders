package servicos;

import modelos.*;
import repositorio.ItemPedidoRepositorio;

import java.util.Map;

public class ItemPedidoService {
    private static ItemPedidoService uniqueInstance = new ItemPedidoService();

    private ItemPedidoService() {
    }

    public static ItemPedidoService getInstance() {
        return uniqueInstance;
    }

    private ItemPedidoRepositorio itemPedidoRepositorio = new ItemPedidoRepositorio();

    public ItemPedido cadastrarItemPedido(Prato prato, int quantidade){
        ItemPedido item = new ItemPedido(prato, quantidade, prato.getPreco());
        itemPedidoRepositorio.add(item);
        return item;
    }

    public ItemPedido getItemPedido(Integer id){
        return itemPedidoRepositorio.getItemPedido(id);
    }

    public ItemPedido getItemPedido(String nome){
        return itemPedidoRepositorio.getItemPedido(nome);
    }

    public Map<Integer, ItemPedido> getItensPedido(){
        return itemPedidoRepositorio.getItensPedido();
    }

    public boolean deleteItemPedido(Integer id){
        return itemPedidoRepositorio.delete(id);
    }

    public boolean deleteItemPedido(String nome){
        ItemPedido itemPedido = itemPedidoRepositorio.getItemPedido(nome);
        return itemPedidoRepositorio.delete(itemPedido.getId());
    }

    /*public Map<Integer, ItemPedido> listaPedidosPorRestaurante(Restaurante restaurante){
        Map<Integer, ItemPedido> pedidosDoRestaurante = new HashMap<>();
        for (ItemPedido item : itemPedidoRepositorio.getItensPedido().values()) {
            if(item.getPrato().getRestaurante().equals(restaurante)){
                pedidosDoRestaurante.put(item.getId(), item);
            }
        }
    }*/
}
