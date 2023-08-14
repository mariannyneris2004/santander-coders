package modelos;

import java.util.List;

public class Pedido{
    private String nomeCliente;
    private String nomeDoRestaurante;
    private List<Prato> pratos;

    private String enderecoDeEntrega;

    public Pedido(String nomeCliente, String nomeDoRestaurante, List<Prato> pratos, String enderecoDeEntrega) {
        this.nomeCliente = nomeCliente;
        this.nomeDoRestaurante = nomeDoRestaurante;
        this.pratos = pratos;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public String toString() {
        return "_____________________________\n" +
                "Restaurante " + nomeDoRestaurante + "\n" +
                "Endereço da entrega: " + enderecoDeEntrega + "\n" +
                "Pedidos: \n" + pratos.toString();
    }
}
