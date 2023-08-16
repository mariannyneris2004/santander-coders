package modelos;

import java.util.HashMap;
import java.util.Map;

public class Pedido{
    private int id;
    private Cliente cliente;
    private Restaurante restaurante;
    private Map<Integer, ItemPedido> itensPedido;
    private String enderecoDeEntrega;

    public Pedido(Cliente cliente, Restaurante restaurante, String enderecoDeEntrega) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.itensPedido = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Map<Integer, ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public String getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public double totalAPagar(){
        double totalAPagar = 0;
        for (ItemPedido item : itensPedido.values()){
            totalAPagar += item.valorTotal();
        }

        return totalAPagar;
    }

    public void adicionarItemPedido(Integer id, ItemPedido itemPedido){
        this.itensPedido.put(id, itemPedido);
    }

    @Override
    public String toString() {
        return "_____________________________\n" +
                "Restaurante " + restaurante.getNome() + "\n" +
                "Cliente: " + cliente.getNome() + "\n" +
                "Endereço da entrega: " + enderecoDeEntrega + "\n" +
                "Pedidos: \n" + itensPedido + "\n" +
                "Total a pagar: R$" + totalAPagar();
    }
}
