package entrada_saida;

import entrada_saida.views.PedidoView;
import entrada_saida.views.PratoView;
import entrada_saida.views.RestauranteView;

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

        switch (operacao){
            case 1:
                RestauranteView.cadastrarRestaurante();
                break;
            case 2:
                RestauranteView.listarRestaurantes();
                break;
            case 3:
                PratoView.cadastrarPrato();
                break;
            case 4:
                PratoView.listarPratosDoRestaurantes();
                break;
            case 5:
                PedidoView.pedir();
                break;
            case 6:
                PedidoView.listarPedidosRestaurante();
                break;
            case 7:
                PedidoView.listarPedidosCliente();
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}