package service;

import java.util.Scanner;

public class MenuSeletorBR implements MenuSeletor {
    @Override
    public int execute() {
        System.out.println("Digite a opção desejada para operar.");
        System.out.println("0 - Sair.");
        System.out.println("1 - Ver saldo.");
        System.out.println("2 - Sacar.");
        System.out.println("3 - Depositar.");
        System.out.println("4 - Transferir.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public boolean tryAgain() {
        System.out.println("Opção inválida. Tente novamente.");
        return true;
    }
}
