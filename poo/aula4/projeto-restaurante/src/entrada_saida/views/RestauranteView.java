package entrada_saida.views;

import entrada_saida.Entrada;
import modelos.Restaurante;
import servicos.RestauranteService;

public class RestauranteView {
    public static void cadastrarRestaurante(){
        RestauranteService service = RestauranteService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();
        System.out.println("Informe o endereço: ");
        String endereco = Entrada.getStringNextLine();

        String msg = service.cadastrarRestaurante(nome, endereco);
        System.out.println(msg);
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

    public static void menuRestaurantes(){
        RestauranteService restauranteService = RestauranteService.getInstance();

        for (int i = 1; i <= restauranteService.getRestaurantes().size(); i++) {
            System.out.println(i + ")" + restauranteService.getRestaurantes().get(i));
        }
        System.out.println("Escolha o restaurante: ");
    }
}
