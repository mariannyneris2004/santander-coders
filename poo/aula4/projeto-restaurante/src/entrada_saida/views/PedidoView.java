package entrada_saida.views;

import entrada_saida.Entrada;
import exceptions.ListaVaziaException;
import exceptions.ObjetoNaoEcontradoException;
import modelos.Cliente;
import modelos.ItemPedido;
import modelos.Pedido;
import modelos.Restaurante;
import servicos.ClienteService;
import servicos.PedidoService;
import servicos.PratoService;
import servicos.RestauranteService;

import java.util.HashMap;
import java.util.Map;

public class PedidoView {
    public static void pedir(){
        RestauranteService restauranteService = RestauranteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();
        PratoService pratoService = PratoService.getInstance();

        try {
            if (!restauranteService.getRestaurantes().isEmpty() && !pratoService.getPratos().isEmpty()){
                RestauranteView.menuRestaurantes();
                int idRestaurante = Entrada.getInt();
                Restaurante restaurante = restauranteService.getRestaurante(idRestaurante);

                Cliente cliente =  ClienteView.cadastrarCliente();
                Map<Integer, ItemPedido> itensAPedir = new HashMap<>();

                Map<Integer, ItemPedido> itensPedido = ItemPedidoView.pedir(itensAPedir, restaurante);

                if (!itensPedido.isEmpty()){
                    System.out.println("Informe o endereço: ");
                    String endereco = Entrada.getStringNextLine();

                    Pedido pedido = pedidoService.cadastrarPedido
                            (cliente, restaurante, endereco, itensPedido);

                    System.out.println(pedido);
                }
            }
        } catch (ListaVaziaException e){
            throw new ListaVaziaException("Pedido vazio!");
        } catch (ObjetoNaoEcontradoException e){
            throw new ObjetoNaoEcontradoException("Prato não encontrado!");
        } catch (NullPointerException e){
            throw new NullPointerException("Prato não encontrado!");
        }
    }

    public static void listarPedidosRestaurante(){
        RestauranteService restauranteService = RestauranteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();

        try {
            if (!restauranteService.getRestaurantes().isEmpty()){
                RestauranteView.menuRestaurantes();
                int idRestaurante = Entrada.getInt();

                Map<Integer, Pedido> pedidosDoRestaurante = pedidoService.listarPedidosRestaurante
                        (restauranteService.getRestaurante(idRestaurante));

                for (Pedido pedido : pedidosDoRestaurante.values()) {
                    System.out.println(pedido);
                }
            }
        } catch (ListaVaziaException e){
            System.out.println(e.getMessage());
        } catch (ObjetoNaoEcontradoException e){
            System.out.println(e.getMessage());
        }
    }

    public static void listarPedidosCliente(){
        ClienteService clienteService = ClienteService.getInstance();
        PedidoService pedidoService = PedidoService.getInstance();

        try {
            if (!clienteService.getClientes().isEmpty() && !clienteService.equals(null)){
                ClienteView.listarClientes();
                int idCliente = Entrada.getInt();

                Map<Integer, Pedido> pedidosDoCliente = pedidoService.listarPedidosCliente
                        (clienteService.getCliente(idCliente));

                for (Pedido pedido : pedidosDoCliente.values()) {
                    System.out.println(pedido);
                }
            }
        } catch (ObjetoNaoEcontradoException e){
            throw new ObjetoNaoEcontradoException("Cliente não encontrado!");
        } catch (RuntimeException e){
            throw new RuntimeException();
        }
    }
}
