package servicos;


import modelos.Pedido;
import modelos.Prato;
import repositorio.PedidoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private PedidoRepositorio pedidoRepositorio;
    private List<Pedido> pedidosRealizados;

    public PedidoService(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.pedidosRealizados = new ArrayList<>();
    }

    public void fazerPedido(String nome, String restaurante, List<Prato> pratosDesejados, String endereco){
        Pedido pedido = new Pedido(nome, restaurante, pratosDesejados, endereco);
        pedidosRealizados.add(pedido);
    }

    public String listarPedidosCadastrados(){
        for (Pedido pedido : pedidosRealizados) {
            return pedido.toString();
        }
        return null;
    }
}
