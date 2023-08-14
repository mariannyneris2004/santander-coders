package entrada_saida;

import modelos.Restaurante;
import repositorio.RestauranteRepositorio;
import servicos.RestauranteService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("APLICATIVO DE ENTREGA DE COMIDA");
        int operacao;

        do {
            menu();
            operacao = Entrada.getInt();
            operacaoARealizar(operacao);
        } while (operacao != 0);
    }

    public static void menu(){
        System.out.println("Menu de operações");
        System.out.println("____________________________________");
        System.out.println("1) Cadastro de restaurantes\n2) Listar restaurantes\n3) Adicionar um prato\n" +
                "4) Listar pratos de um restaurante\n5) Fazer um pedido\n6) Listar pedidos de um restaurante\n" +
                "7) Listar pedidos realizados por cliente\n0) Encerrar aplicativo");
        System.out.println("____________________________________");
        System.out.println("O que deseja realizar?");
    }

    public static void operacaoARealizar(int operacao){
        RestauranteService service = new RestauranteService(new RestauranteRepositorio());
        switch (operacao){
            case 1:
                System.out.println("Informe o nome do restaurante: ");
                String nome = Entrada.getStringNextLine();
                System.out.println("Informe o endereço do restaurante: ");
                String endereco = Entrada.getStringNextLine();

                service.cadastrarRestaurante(nome, endereco);
                System.out.println("Restaurante cadastrado!");
                break;
            case 2:
                //System.out.println(Arrays.toString(service.listarRestaurantesCadastrados().toArray(new Restaurante[0])));
                for (String restaurante : service.listarRestaurantesCadastrados()) {
                    System.out.println(restaurante);
                }
        }
    }
}