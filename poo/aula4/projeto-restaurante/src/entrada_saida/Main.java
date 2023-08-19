package entrada_saida;

import entrada_saida.views.PedidoView;
import entrada_saida.views.PratoView;
import entrada_saida.views.RestauranteView;
import exceptions.ListaVaziaException;
import exceptions.ObjetoNaoEcontradoException;

import java.util.InputMismatchException;

public class Main {
        public static void main(String[] args) {
        System.out.println("APLICATIVO DE ENTREGA DE COMIDA");
        int operacao = -1;

        do {
            try {
                menu();
                operacao = Entrada.getInt();
                operacaoARealizar(operacao);
            } catch (InputMismatchException e){
                System.out.println("Valor inválido!");
            }
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
                try {
                    RestauranteView.cadastrarRestaurante();
                    break;
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            case 2:
                try {
                    RestauranteView.listarRestaurantes();
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    PratoView.cadastrarPrato();
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try {
                    PratoView.listarPratosDoRestaurantes();
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                try {
                    PedidoView.pedir();
                    break;
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            case 6:
                try {
                    PedidoView.listarPedidosRestaurante();
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 7:
                try {
                    PedidoView.listarPedidosCliente();
                } catch (ObjetoNaoEcontradoException e){
                    System.out.println(e.getMessage());
                } catch (ListaVaziaException e){
                    System.out.println(e.getMessage());
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}