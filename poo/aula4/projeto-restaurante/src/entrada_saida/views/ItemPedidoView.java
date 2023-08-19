package entrada_saida.views;

import entrada_saida.Entrada;
import exceptions.ObjetoNaoEcontradoException;
import modelos.ItemPedido;
import modelos.Prato;
import modelos.Restaurante;
import servicos.ItemPedidoService;
import servicos.PratoService;
import servicos.RestauranteService;

import java.util.Map;

public class ItemPedidoView {
    public static Map<Integer, ItemPedido> pedir(Map<Integer, ItemPedido> itensPedido, Restaurante restaurante){
        PratoService pratoService = PratoService.getInstance();
        ItemPedidoService itemPedidoService = ItemPedidoService.getInstance();

        try {
            String continuar;
            do {
                System.out.println("Informe o nome do prato: ");
                String nome = Entrada.getStringNextLine();
                Prato prato = pratoService.getPrato(nome, restaurante);

                System.out.println("Informe a quantidade: ");
                int quantidade = Entrada.getInt();

                ItemPedido itemPedido = itemPedidoService.cadastrarItemPedido(prato, quantidade);

                itensPedido.put(itemPedido.getId(), itemPedido);
                System.out.println("Deseja pedir algo mais? (y/n)");

                continuar = Entrada.getStringNext();
            } while (continuar.equals("y"));

            return itensPedido;
        } catch (ObjetoNaoEcontradoException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void removerRestaurante(){
        RestauranteService service = RestauranteService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        boolean remover = service.deleteRestaurante(nome);
        if (remover){
            System.out.println("Removido com sucesso");
        }
    }

    public static void buscarCliente(){
        RestauranteService service = RestauranteService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        service.getRestaurante(nome);
    }

    public static void listarRestaurantes(){
        RestauranteService service = RestauranteService.getInstance();

        System.out.println("LISTA DE RESTAURANTES");
        for (Restaurante restaurante : service.getRestaurantes().values()) {
            System.out.println(restaurante);
        }
    }
}
