package entrada_saida.views;

import entrada_saida.Entrada;
import modelos.Prato;
import servicos.PratoService;
import servicos.RestauranteService;

public class PratoView {
    public static void cadastrarPrato(){
        PratoService service = PratoService.getInstance();
        RestauranteService restauranteService = RestauranteService.getInstance();

        RestauranteView.menuRestaurantes();
        System.out.println("Selecione o restaurante: ");
        int restauranteId = Entrada.getInt();

        System.out.println("Informe o nome do prato: ");
        String nome = Entrada.getStringNextLine();
        System.out.println("Informe o preço do prato: ");
        double preco = Entrada.getDouble();
        System.out.println("Informe uma descrição: ");
        String descricao = Entrada.getStringNextLine();

        service.cadastrarPrato(nome, preco, descricao, restauranteService.getRestaurante(restauranteId));
        System.out.println("Prato cadastrado!");
    }

    public static void removerPrato(){
        PratoService service = PratoService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        boolean remover = service.deletePrato(nome);
        if (remover){
            System.out.println("Removido com sucesso");
        }
    }

    public static void buscarPrato(){
        PratoService service = PratoService.getInstance();

        System.out.println("Informe o nome: ");
        String nome = Entrada.getStringNextLine();

        service.getPrato(nome);
    }

    public static void listarPratosDoRestaurantes(){
        PratoService service = PratoService.getInstance();
        RestauranteService restauranteService = RestauranteService.getInstance();

        RestauranteView.menuRestaurantes();
        System.out.println("Selecione o restaurante: ");
        int restauranteId = Entrada.getInt();

        System.out.println("LISTA DE PRATOS");
        for (Prato prato : service.getPratos().values()) {
            if(prato.getRestaurante().getId() == restauranteId){
                System.out.println(prato);
            }
        }
    }
}
