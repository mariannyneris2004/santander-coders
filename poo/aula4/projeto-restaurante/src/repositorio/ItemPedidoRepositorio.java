package repositorio;

import modelos.ItemPedido;

import java.util.HashMap;
import java.util.Map;

public class ItemPedidoRepositorio {
    private Map<Integer, ItemPedido> itensPedido;

    public ItemPedidoRepositorio() {
        this.itensPedido = new HashMap<>();
    }

    public void add(ItemPedido itemPedido){
        itemPedido.setId(itensPedido.size() + 1);

        this.itensPedido.put(itemPedido.getId(), itemPedido);
    }

    public ItemPedido getItemPedido(String nome) {
        for (ItemPedido itemPedido : itensPedido.values()) {
            if(itemPedido.getPrato().getNome().equals(nome)){
                return itemPedido;
            }
        }
        return null;
    }

    public ItemPedido getItemPedido(Integer id) {
        return itensPedido.get(id);
    }

    public boolean delete(Integer id) {
        if (itensPedido.get(id) != null) {
            itensPedido.remove(id);
            return true;
        }

        return false;
    }

    public Map<Integer, ItemPedido> getItensPedido() {
        return this.itensPedido;
    }
}
