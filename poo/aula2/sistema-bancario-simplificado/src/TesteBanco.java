import java.util.ArrayList;
import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SISTEMA BANCÁRIO SIMPLIFICADO");
        int operacoes = -1;
        Banco banco = new Banco();
        ArrayList<Conta> contas = new ArrayList<>();

        do {
            System.out.println("Menu de operações:\n1) Criar conta\n2) Depositar\n3) Sacar\n4) Consultar dados " +
                    "da conta\n0) Encerrar atendimento");
            System.out.println("O que deseja?");
            operacoes = scanner.nextInt();

            switch (operacoes){
                case 1:
                    Conta conta = banco.criarConta();
                    contas.add(conta);
                    banco.setContas(contas);
                    break;
                case 2:
                    try{
                        banco.depositar();
                    } catch (OperacoesException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        banco.sacar();
                    } catch (OperacoesException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try{
                        System.out.println(banco.buscarConta());
                    } catch (OperacoesException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Obrigado pela preferência!");
                    break;
            }
        } while (operacoes != 0);

        scanner.close();
    }
}