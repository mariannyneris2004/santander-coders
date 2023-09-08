package service;

import java.util.Scanner;

public class MenuSeletorEUA implements MenuSeletor {
    @Override
    public int execute() {
        System.out.println("Enter the desired option to operate.");
        System.out.println("0 - Exit.");
        System.out.println("1 - Check balance.");
        System.out.println("2 - Withdraw.");
        System.out.println("3 - Cash deposit.");
        System.out.println("4 - Transfer.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public boolean tryAgain() {
        System.out.println("Invalid option. Try again.");
        return true;
    }
}
