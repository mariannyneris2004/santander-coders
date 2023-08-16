package entrada_saida.views;

import entrada_saida.Entrada;
import modelos.Cliente;
import modelos.ItemPedido;
import modelos.Pedido;
import servicos.ClienteService;
import servicos.PedidoService;
import servicos.RestauranteService;

import java.util.HashMap;
import java.util.Map;

public class PedidoView {
    public static void pedir(){
        RestauranteService restauranteService = RestauranteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();

        RestauranteView.menuRestaurantes();
        int idRestaurante = Entrada.getInt();
        Cliente cliente =  ClienteView.cadastrarCliente();
        Map<Integer, ItemPedido> itensAPedir = new HashMap<>();

        Map<Integer, ItemPedido> itensPedido = ItemPedidoView.pedir(itensAPedir);

        System.out.println("Informe o endereço: ");
        String endereco = Entrada.getStringNextLine();

        Pedido pedido = pedidoService.cadastrarPedido
                (cliente, restauranteService.getRestaurante(idRestaurante), endereco, itensPedido);

        System.out.println(pedido);
    }

    public static void listarPedidosRestaurante(){
        RestauranteService restauranteService = RestauranteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();

        RestauranteView.menuRestaurantes();
        int idRestaurante = Entrada.getInt();

        Map<Integer, Pedido> pedidosDoRestaurante = pedidoService.listarPedidosRestaurante
                (restauranteService.getRestaurante(idRestaurante));

        for (Pedido pedido : pedidosDoRestaurante.values()) {
            System.out.println(pedido);
        }
    }

    public static void listarPedidosCliente(){
        ClienteService clienteService = ClienteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();

        ClienteView.listarClientes();
        int idCliente = Entrada.getInt();

        Map<Integer, Pedido> pedidosDoRestaurante = pedidoService.listarPedidosCliente
                (clienteService.getCliente(idCliente));

        for (Pedido pedido : pedidosDoRestaurante.values()) {
            System.out.println(pedido);
        }
    }
}
